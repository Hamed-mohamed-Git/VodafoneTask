package com.vodafone.task.core.data.searchCities.mapper

import com.vodafone.task.core.database.model.CityEntity
import com.vodafone.task.core.model.city.City
import com.vodafone.task.core.network.model.CityResponse

//For Mapping From Remote to UI
internal fun List<CityResponse>.asCity() = map(CityResponse::asCity)

internal fun CityResponse.asCity() =
    City(
        cityName = name ?: "",
        cityLat = latitude ?: 0.0,
        cityLong = longitude ?: 0.0
    )

//For Mapping From Remote to Local
internal fun CityResponse.asCityEntity() =
    CityEntity(
        cityName = name ?: "",
        cityLat = latitude ?: 0.0,
        cityLong = longitude ?: 0.0
    )
