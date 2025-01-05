package com.vodafone.task.core.data.weather.mapper

import com.vodafone.task.core.model.weather.Weather
import com.vodafone.task.core.network.model.WeatherResponse

fun WeatherResponse.asWeather() =
    Weather(
        timezone = timezone,
        temperature = current.temperature,
        feelsLike = current.feelsLike,
        pressure = current.pressure,
        humidity = current.humidity,
        uvi = current.uvi,
        windSpeed = current.windSpeed,
        description = current.weather[0].description,
        iconSet = current.weather[0].icon,
        daily = dailyResponse.map(WeatherResponse.DailyResponse::asDaily)
    )

private fun WeatherResponse.DailyResponse.asDaily() = Weather
    .Daily(
        temp = temperature.day,
        feelsLike = feelsLike.day,
        description = weather[0].description,
        dateTime = dateTime,
        iconSet = weather[0].icon
    )