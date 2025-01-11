package com.vodafone.task.core.data.weather.repo

import com.vodafone.task.core.model.weather.Weather
import com.vodafone.task.core.model.weather.WeatherRequest
import com.vodafone.task.core.model.VodafoneTaskResource

typealias WeatherResource = VodafoneTaskResource<Weather>

interface WeatherRepo {
    suspend fun loadWeather(request: WeatherRequest) : WeatherResource
}