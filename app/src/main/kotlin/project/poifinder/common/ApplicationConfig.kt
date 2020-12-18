package project.poifinder.common

import project.poifinder.di.*

val appModules = listOf(
    viewModelModule,
    networkModule,
    apiModule,
    remoteModule
)

const val NAVER_MAP_CLIENT_ID = "co6pcbko80"

const val NAVER_API_CLIENT_ID = "Siq1gmWMA4epgC0f1rRw"
const val NAVER_API_CLIENT_SECRET = "htkYqHwh5q"

const val CONNECT_TIMEOUT = 10L
const val WRITE_TIMEOUT = 1L
const val READ_TIMEOUT = 10L
const val BASE_URL = "https://openapi.naver.com/"

const val SEARCH_RESPONSE_START_POSITION = 1
const val SEARCH_RESPONSE_LIST_COUNT = 50
const val SEARCH_RESPONSE_DISPLAY_COUNT = 5