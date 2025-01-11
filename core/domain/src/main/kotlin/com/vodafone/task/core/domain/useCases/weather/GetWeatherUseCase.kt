package com.vodafone.task.core.domain.useCases.weather

import com.vodafone.task.core.data.weather.repo.WeatherRepo
import com.vodafone.task.core.data.weather.repo.WeatherResource
import com.vodafone.task.core.model.weather.WeatherRequest
import javax.inject.Inject

fun interface GetWeatherUseCaseType {
    suspend operator fun invoke(request:WeatherRequest): WeatherResource
}

internal class GetWeatherUseCase @Inject constructor(
    private val repo: WeatherRepo
): GetWeatherUseCaseType {

    override suspend operator fun invoke(request: WeatherRequest) = repo
        .loadWeather(request = request)

}