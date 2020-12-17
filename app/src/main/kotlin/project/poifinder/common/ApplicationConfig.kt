package project.poifinder.project.poifinder.common

import project.poifinder.project.poifinder.di.*

val appModules = listOf(
    viewModelModule,
    networkModule,
    apiModule,
    reposirotyModule,
    remoteModule
)

const val CONNECT_TIMEOUT = 10L
const val WRITE_TIMEOUT = 1L
const val READ_TIMEOUT = 20L
const val BASE_URL = "https://jsonplaceholder.typicode.com/"