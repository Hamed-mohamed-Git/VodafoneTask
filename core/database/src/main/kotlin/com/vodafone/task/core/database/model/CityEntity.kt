package com.vodafone.task.core.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityEntity(
    @PrimaryKey
    val cityName: String,
    val cityLat: Double,
    val cityLong: Double
)