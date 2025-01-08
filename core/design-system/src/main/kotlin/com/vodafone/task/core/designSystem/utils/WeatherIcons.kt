package com.vodafone.task.core.designSystem.utils

import androidx.annotation.StringDef
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.vodafone.task.core.designSystem.theme.VTIcons

@StringDef(
    WeatherIcons.D1,
    WeatherIcons.D2,
    WeatherIcons.D3,
    WeatherIcons.D4,
    WeatherIcons.D9,
    WeatherIcons.D10,
    WeatherIcons.N1,
    WeatherIcons.N2,
    WeatherIcons.N3,
    WeatherIcons.N4,
    WeatherIcons.N9,
    WeatherIcons.N10,
    WeatherIcons.D11,
    WeatherIcons.D13,
    WeatherIcons.D50,
    WeatherIcons.N11,
    WeatherIcons.N13,
    WeatherIcons.N50
)
@Retention(AnnotationRetention.SOURCE)
annotation class WeatherIcons {
    companion object {
        const val D1 = "01d"
        const val D2 = "02d"
        const val D3 = "03d"
        const val D4 = "04d"
        const val D9 = "09d"
        const val D10 = "10d"
        const val D11 = "11d"
        const val D13 = "13d"
        const val D50 = "50d"
        const val N1 = "01n"
        const val N2 = "02n"
        const val N3 = "03n"
        const val N4 = "04n"
        const val N9 = "09n"
        const val N10 = "10n"
        const val N11 = "11n"
        const val N13 = "13n"
        const val N50 = "50n"
    }
}

@Composable
fun MaterialTheme.findWeatherLogo(@WeatherIcons name: String) =
    when (name) {
        WeatherIcons.D1 -> VTIcons.clearSky
        WeatherIcons.D2 -> VTIcons.fewClouds
        WeatherIcons.D3 -> VTIcons.scatteredClouds
        WeatherIcons.D4 -> VTIcons.brokenClouds
        WeatherIcons.D9 -> VTIcons.showerRain
        WeatherIcons.D10 -> VTIcons.rain
        WeatherIcons.D11 -> VTIcons.thunderstorm
        WeatherIcons.D13 -> VTIcons.snow
        WeatherIcons.D50 -> VTIcons.mist
        WeatherIcons.N1 -> VTIcons.nightClearSky
        WeatherIcons.N2 -> VTIcons.nightFewClouds
        WeatherIcons.N3 -> VTIcons.nightScatteredClouds
        WeatherIcons.N4 -> VTIcons.nightBrokenClouds
        WeatherIcons.N9 -> VTIcons.nightShowerRain
        WeatherIcons.N10 -> VTIcons.nightRain
        WeatherIcons.N11 -> VTIcons.nightThunderstorm
        WeatherIcons.N13 -> VTIcons.nightSnow
        WeatherIcons.N50 -> VTIcons.nightMist
        else -> VTIcons.mist
    }