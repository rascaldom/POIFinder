package project.poifinder.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import project.poifinder.common.SEARCH_RESPONSE_DISPLAY_COUNT
import project.poifinder.common.SEARCH_RESPONSE_LIST_COUNT
import project.poifinder.common.SEARCH_RESPONSE_START_POSITION
import project.poifinder.data.model.Item
import project.poifinder.data.remote.SearchDataSource

class MainViewModel(private val remote: SearchDataSource) : ViewModel() {

    private val _list = MutableLiveData<List<Item>>()

    val list: LiveData<List<Item>> get() = _list

    fun getSearchList(query: String) {
        viewModelScope.launch {
            _list.value = convertItemList(fetch(query, getStartPositionList()).values.toList())
        }
    }

    private fun getStartPositionList(): MutableIterable<Int> = mutableListOf<Int>().apply {
        var temp = SEARCH_RESPONSE_START_POSITION
        for (i in 1..SEARCH_RESPONSE_LIST_COUNT / SEARCH_RESPONSE_DISPLAY_COUNT) {
            add(temp)
            temp += SEARCH_RESPONSE_DISPLAY_COUNT
        }
    }

    private suspend fun fetch(query: String, startPosition: Iterable<Int>): Map<Int, List<Item>> = coroutineScope {
        startPosition.map { position ->
                async {
                    position to remote.getSearchList(mapOf(
                    "query" to query,
                    "display" to SEARCH_RESPONSE_DISPLAY_COUNT.toString(),
                    "start" to position.toString(),
                    "sort" to "random")).items
                }
            }
            .map {
                it.await()
            }
            .toMap()
    }

    private fun convertItemList(resultList: List<List<Item>>): List<Item> = mutableListOf<Item>().apply {
        resultList.let {
            for (i in it.indices) {
                it[i].forEach { item ->
                    add(item)
                }
            }
        }
    }
}