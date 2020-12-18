package project.poifinder.data.api

import project.poifinder.common.NAVER_API_CLIENT_ID
import project.poifinder.common.NAVER_API_CLIENT_SECRET
import project.poifinder.data.model.SearchModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface SearchApi {

    @GET("/v1/search/local.json")
    @Headers(
        "X-Naver-Client-Id: ${NAVER_API_CLIENT_ID}",
        "X-Naver-Client-Secret: ${NAVER_API_CLIENT_SECRET}")
    suspend fun getList(@QueryMap map: Map<String, String>): SearchModel

}