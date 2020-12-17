package project.poifinder.project.poifinder.di

import org.koin.dsl.module
import project.poifinder.project.poifinder.data.remote.SampleRemote
import project.poifinder.project.poifinder.data.repository.Repository
import project.poifinder.project.poifinder.data.repository.RepositoryImpl

val reposirotyModule = module {

    single<Repository> {
        RepositoryImpl(remote = get())
    }

}