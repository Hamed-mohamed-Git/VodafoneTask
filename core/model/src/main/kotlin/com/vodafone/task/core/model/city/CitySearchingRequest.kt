package com.vodafone.task.core.model.city

data class CitySearchingRequest(
    val cityName: String,
    val limit: Int = 5,
)
