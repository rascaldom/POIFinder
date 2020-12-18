package project.poifinder.di

import org.koin.dsl.module
import project.poifinder.data.api.SearchApi
import retrofit2.Retrofit

val apiModule = module {

    single {
        get<Retrofit>().create(SearchApi::class.java)
    }

}