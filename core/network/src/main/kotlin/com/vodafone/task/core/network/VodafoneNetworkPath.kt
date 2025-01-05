package com.vodafone.task.core.network

internal object VodafoneNetworkPath {
    const val ONE_CALL_PATH = "onecall"
    const val SEARCH_CITY_PATH = "/geo/1.0/direct"

    object Weather {
        const val ONE_CALL = ONE_CALL_PATH
    }

    object City {
        const val SEARCHING_CITY = SEARCH_CITY_PATH
    }
}