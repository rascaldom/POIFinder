package project.poifinder.project.poifinder.data.api

import project.poifinder.project.poifinder.network.dto.SampleDto
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.QueryMap

interface SampleApi {

    @GET("/photos")
    @Headers("Accept: application/json")
    suspend fun getList(@QueryMap map: Map<String, String>): List<SampleDto>

}