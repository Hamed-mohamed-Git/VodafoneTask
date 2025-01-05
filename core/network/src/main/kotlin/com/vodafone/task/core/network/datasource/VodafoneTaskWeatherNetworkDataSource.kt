package com.vodafone.task.core.network.datasource

import com.vodafone.task.core.model.weather.WeatherRequest
import com.vodafone.task.core.network.VodafoneTaskResource
import com.vodafone.task.core.network.model.WeatherResponse

interface VodafoneTaskWeatherNetworkDataSource {
    suspend fun fetchWeather(request: WeatherRequest): VodafoneTaskResource<WeatherResponse>
}