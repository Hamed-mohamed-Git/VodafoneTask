package com.vodafone.task.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vodafone.task.core.database.dao.CityDao
import com.vodafone.task.core.database.model.CityEntity


@Database(
    entities = [CityEntity::class],
    version = 1,
    exportSchema = true
)
internal abstract class VodafoneTaskDatabase: RoomDatabase() {
    abstract fun cityDao(): CityDao
}