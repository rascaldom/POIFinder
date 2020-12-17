package project.poifinder.project.poifinder.data.remote

import project.poifinder.project.poifinder.network.dto.SampleDto

interface SampleRemote {

    suspend fun getSample(param: Map<String, String>) : List<SampleDto>

}