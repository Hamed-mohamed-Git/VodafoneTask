package com.vodafone.task.core.data.weather.repo

import com.vodafone.task.core.common.map
import com.vodafone.task.core.data.weather.mapper.asWeather
import com.vodafone.task.core.model.weather.Weather
import com.vodafone.task.core.model.weather.WeatherRequest
import com.vodafone.task.core.network.VodafoneTaskResource
import com.vodafone.task.core.network.datasource.VodafoneTaskWeatherNetworkDataSource
import com.vodafone.task.core.network.model.WeatherResponse
import javax.inject.Inject

internal class WeatherRepoImpl @Inject constructor(
    private val dataSource: VodafoneTaskWeatherNetworkDataSource
) : WeatherRepo {

    override suspend fun loadWeather(request: WeatherRequest): WeatherResource = dataSource
        .fetchWeather(request)
        .map(WeatherResponse::asWeather)

}