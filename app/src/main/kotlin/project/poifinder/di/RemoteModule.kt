package project.poifinder.project.poifinder.di

import org.koin.dsl.module
import project.poifinder.project.poifinder.data.remote.SampleRemote
import project.poifinder.project.poifinder.data.remote.SampleRemoteImpl

val remoteModule = module {

    single<SampleRemote> {
        SampleRemoteImpl(api = get())
    }

}