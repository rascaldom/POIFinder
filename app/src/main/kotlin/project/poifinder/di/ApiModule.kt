package project.poifinder.project.poifinder.di

import org.koin.dsl.module
import project.poifinder.project.poifinder.data.api.SampleApi
import retrofit2.Retrofit

val apiModule = module {

    single {
        get<Retrofit>().create(SampleApi::class.java)
    }

}