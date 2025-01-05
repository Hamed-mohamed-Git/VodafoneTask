package com.vodafone.task.core.domain.useCases.weather

import com.vodafone.task.core.data.weather.repo.WeatherRepo
import com.vodafone.task.core.model.weather.WeatherRequest
import javax.inject.Inject

class GetWeatherUseCase @Inject internal constructor(private val repo: WeatherRepo) {

    suspend operator fun invoke(request: WeatherRequest) = repo
        .loadWeather(request = request)

}