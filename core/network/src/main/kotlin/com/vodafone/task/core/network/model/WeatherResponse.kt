package com.vodafone.task.core.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class WeatherResponse(
    @SerialName("lat") val latitude: Double,
    @SerialName("lon") val longitude: Double,
    @SerialName("timezone") val timezone: String,
    @SerialName("timezone_offset") val timezoneOffset: Int,
    @SerialName("current") val current: CurrentWeather,
    @SerialName("minutely") val minutely: List<Minutely>,
    @SerialName("hourly") val hourly: List<Hourly>,
    @SerialName("daily") val dailyResponse: List<DailyResponse>,
    @SerialName("alerts") val alerts: List<Alert>?
) {

    @Serializable
    data class CurrentWeather(
        @SerialName("dt") val dateTime: Long,
        @SerialName("sunrise") val sunrise: Long,
        @SerialName("sunset") val sunset: Long,
        @SerialName("temp") val temperature: Double,
        @SerialName("feels_like") val feelsLike: Double,
        @SerialName("pressure") val pressure: Int,
        @SerialName("humidity") val humidity: Int,
        @SerialName("dew_point") val dewPoint: Double,
        @SerialName("uvi") val uvi: Double,
        @SerialName("clouds") val clouds: Int,
        @SerialName("visibility") val visibility: Int,
        @SerialName("wind_speed") val windSpeed: Double,
        @SerialName("wind_deg") val windDegree: Int,
        @SerialName("wind_gust") val windGust: Double,
        @SerialName("weather") val weather: List<Weather>
    )

    @Serializable
    data class Minutely(
        @SerialName("dt") val dateTime: Long,
        @SerialName("precipitation") val precipitation: Double
    )

    @Serializable
    data class Hourly(
        @SerialName("dt") val dateTime: Long,
        @SerialName("temp") val temperature: Double,
        @SerialName("feels_like") val feelsLike: Double,
        @SerialName("pressure") val pressure: Int,
        @SerialName("humidity") val humidity: Int,
        @SerialName("dew_point") val dewPoint: Double,
        @SerialName("uvi") val uvi: Double,
        @SerialName("clouds") val clouds: Int,
        @SerialName("visibility") val visibility: Int,
        @SerialName("wind_speed") val windSpeed: Double,
        @SerialName("wind_deg") val windDegree: Int,
        @SerialName("wind_gust") val windGust: Double,
        @SerialName("weather") val weather: List<Weather>,
        @SerialName("pop") val pop: Double
    )

    @Serializable
    data class DailyResponse(
        @SerialName("dt") val dateTime: Double,
        @SerialName("sunrise") val sunrise: Long,
        @SerialName("sunset") val sunset: Long,
        @SerialName("moonrise") val moonrise: Long,
        @SerialName("moonset") val moonset: Long,
        @SerialName("moon_phase") val moonPhase: Double,
        @SerialName("summary") val summary: String,
        @SerialName("temp") val temperature: Temperature,
        @SerialName("feels_like") val feelsLike: FeelsLike,
        @SerialName("pressure") val pressure: Int,
        @SerialName("humidity") val humidity: Int,
        @SerialName("dew_point") val dewPoint: Double,
        @SerialName("wind_speed") val windSpeed: Double,
        @SerialName("wind_deg") val windDegree: Int,
        @SerialName("wind_gust") val windGust: Double,
        @SerialName("weather") val weather: List<Weather>,
        @SerialName("clouds") val clouds: Int,
        @SerialName("pop") val pop: Double,
        @SerialName("rain") val rain: Double?,
        @SerialName("uvi") val uvi: Double
    )

    @Serializable
    data class Temperature(
        @SerialName("day") val day: Double,
        @SerialName("min") val min: Double,
        @SerialName("max") val max: Double,
        @SerialName("night") val night: Double,
        @SerialName("eve") val evening: Double,
        @SerialName("morn") val morning: Double
    )

    @Serializable
    data class FeelsLike(
        @SerialName("day") val day: Double,
        @SerialName("night") val night: Double,
        @SerialName("eve") val evening: Double,
        @SerialName("morn") val morning: Double
    )

    @Serializable
    data class Weather(
        @SerialName("id") val id: Int,
        @SerialName("main") val main: String,
        @SerialName("description") val description: String,
        @SerialName("icon") val icon: String
    )

    @Serializable
    data class Alert(
        @SerialName("sender_name") val senderName: String,
        @SerialName("event") val event: String,
        @SerialName("start") val start: Long,
        @SerialName("end") val end: Long,
        @SerialName("description") val description: String,
        @SerialName("tags") val tags: List<String>
    )
}