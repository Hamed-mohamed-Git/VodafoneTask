package com.vodafone.task.core.network.model

import kotlinx.serialization.SerialName

data class CityResponse (
    @SerialName("name") val name: String?,
    @SerialName("lat") val latitude: Double?,
    @SerialName("lon") val longitude: Double?,
    @SerialName("country") val country: String?,
    @SerialName("state") val state: String?
)
