package project.poifinder.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import project.poifinder.ui.main.MainViewModel

val viewModelModule = module {

    viewModel {
        MainViewModel(remote = get())
    }

}