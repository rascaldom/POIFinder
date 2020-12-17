package project.poifinder.project.poifinder.data.repository

import project.poifinder.project.poifinder.data.remote.SampleRemote
import project.poifinder.project.poifinder.network.dto.SampleDto

class RepositoryImpl(private val remote: SampleRemote) : Repository {

    override suspend fun getSample(param: Map<String, String>): List<SampleDto> = remote.getSample(param)

}