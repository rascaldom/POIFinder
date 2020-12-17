package project.poifinder.project.poifinder.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import project.poifinder.project.poifinder.data.repository.Repository
import project.poifinder.project.poifinder.network.dto.SampleDto

class MainViewModel(private val repository: Repository) : ViewModel() {

    val sampleList: LiveData<List<SampleDto>> = liveData(Dispatchers.IO) {
        emit(repository.getSample(mapOf("albumId" to "1")))
    }

}