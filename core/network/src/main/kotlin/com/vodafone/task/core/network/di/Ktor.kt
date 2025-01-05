package com.vodafone.task.core.network.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.vodafone.task.core.network.BuildConfig
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal fun httpClientEngine(context: Context): HttpClientEngine =
    OkHttp.create { addInterceptor(ChuckerInterceptor.Builder(context).build()) }

internal fun ktorClient(engine: HttpClientEngine): HttpClient =
    HttpClient(engine) {

        defaultRequest {
            contentType(ContentType.Application.Json)
            url(BuildConfig.BASE_URL)
        }


        install(ContentNegotiation) {
            json(VodafoneJson)
        }

        install(Logging) {
            level = LogLevel.INFO
        }

    }


private val VodafoneJson = Json {
    encodeDefaults = true
    isLenient = true
    allowSpecialFloatingPointValues = true
    allowStructuredMapKeys = true
    prettyPrint = true
    useArrayPolymorphism = false
    ignoreUnknownKeys = true
    explicitNulls = true
}