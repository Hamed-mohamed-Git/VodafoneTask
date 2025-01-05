package com.vodafone.task.core.model.weather

data class WeatherRequest(
    val lat: Double,
    val lon: Double,
    val units: String = "metric",
    val lang: String = "en",
)
