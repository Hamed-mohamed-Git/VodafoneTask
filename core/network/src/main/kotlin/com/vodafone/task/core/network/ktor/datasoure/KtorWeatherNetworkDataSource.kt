package com.vodafone.task.core.network.ktor.datasoure

import com.vodafone.task.core.model.weather.WeatherRequest
import com.vodafone.task.core.network.BuildConfig
import com.vodafone.task.core.network.VodafoneNetworkPath
import com.vodafone.task.core.network.VodafoneTaskResource
import com.vodafone.task.core.network.datasource.VodafoneTaskWeatherNetworkDataSource
import com.vodafone.task.core.network.ktor.apiCall
import com.vodafone.task.core.network.model.WeatherResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

internal class KtorWeatherNetworkDataSource @Inject constructor(
    private val client: HttpClient
): VodafoneTaskWeatherNetworkDataSource {

    override suspend fun fetchWeather(request: WeatherRequest): VodafoneTaskResource<WeatherResponse> =
        client.apiCall {
            get(VodafoneNetworkPath.Weather.ONE_CALL){
                parameter("lat", request.lat)
                parameter("lon", request.lon)
                parameter("lang", request.lang)
                parameter("units", request.units)
                parameter("appId", BuildConfig.API_KEY)
            }
        }

}