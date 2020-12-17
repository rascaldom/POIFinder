package project.poifinder.project.poifinder.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import project.poifinder.project.poifinder.ui.main.MainViewModel

val viewModelModule = module {

    viewModel {
        MainViewModel(repository = get())
    }

}