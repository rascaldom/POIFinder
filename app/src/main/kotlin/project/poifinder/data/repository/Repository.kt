package project.poifinder.project.poifinder.data.repository

import project.poifinder.project.poifinder.network.dto.SampleDto

interface Repository {

    suspend fun getSample(param: Map<String, String>) : List<SampleDto>

}