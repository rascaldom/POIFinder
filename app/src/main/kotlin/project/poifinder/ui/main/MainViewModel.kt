package project.poifinder.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import project.poifinder.common.SEARCH_RESPONSE_DISPLAY_COUNT
import project.poifinder.common.SEARCH_RESPONSE_LIST_COUNT
import project.poifinder.common.SEARCH_RESPONSE_START_POSITION
import project.poifinder.data.model.Item
import project.poifinder.data.remote.SearchDataSource

class MainViewModel(private val remote: SearchDataSource) : ViewModel() {

    fun getSearchList(query: String) = liveData(Dispatchers.IO) {
            try {
                emit(convertItemList(fetch(query, getStartPositionList()).values.toList()))
            } catch (e: Exception) {
                e.printStackTrace()
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
        resultList.let{
            for (i in it.indices) {
                it[i].forEach { item ->
                    add(item)
                }
            }
        }
    }
}