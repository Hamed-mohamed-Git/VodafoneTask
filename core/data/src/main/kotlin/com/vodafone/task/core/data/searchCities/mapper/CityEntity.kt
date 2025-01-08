package com.vodafone.task.core.data.searchCities.mapper

import com.vodafone.task.core.database.model.CityEntity
import com.vodafone.task.core.model.city.City

//For Mapping From Local to UI
internal fun List<CityEntity>.asCity() = map(CityEntity::asCity)

private fun CityEntity.asCity() =
    City(
        cityName = cityName,
        cityLat = cityLat,
        cityLong = cityLong
    )