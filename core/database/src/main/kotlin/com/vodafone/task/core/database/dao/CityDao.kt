package com.vodafone.task.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.vodafone.task.core.database.model.CityEntity

@Dao
interface CityDao {

    @Query("SELECT * FROM CityEntity")
    suspend fun loadAllCities(): List<CityEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(vararg city: CityEntity)

}