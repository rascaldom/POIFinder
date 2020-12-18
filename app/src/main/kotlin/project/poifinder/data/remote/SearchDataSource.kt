package project.poifinder.data.remote

import project.poifinder.data.model.SearchModel

interface SearchDataSource {

    suspend fun getSearchList(param: Map<String, String>) : SearchModel

}
