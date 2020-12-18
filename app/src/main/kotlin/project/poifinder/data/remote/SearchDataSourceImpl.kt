package project.poifinder.data.remote

import project.poifinder.data.api.SearchApi
import project.poifinder.data.model.SearchModel

class SearchDataSourceImpl(private val api: SearchApi) : SearchDataSource {

    override suspend fun getSearchList(param: Map<String, String>): SearchModel = api.getList(param)

}