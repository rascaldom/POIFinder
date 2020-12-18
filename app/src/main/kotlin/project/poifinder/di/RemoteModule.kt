package project.poifinder.di

import org.koin.dsl.module
import project.poifinder.data.remote.SearchDataSource
import project.poifinder.data.remote.SearchDataSourceImpl

val remoteModule = module {

    single<SearchDataSource> {
        SearchDataSourceImpl(api = get())
    }

}