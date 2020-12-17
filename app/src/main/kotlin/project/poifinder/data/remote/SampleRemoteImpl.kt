package project.poifinder.project.poifinder.data.remote

import project.poifinder.project.poifinder.data.api.SampleApi
import project.poifinder.project.poifinder.network.dto.SampleDto

class SampleRemoteImpl(private val api: SampleApi) : SampleRemote {

    override suspend fun getSample(param: Map<String, String>): List<SampleDto> = api.getList(param)

}