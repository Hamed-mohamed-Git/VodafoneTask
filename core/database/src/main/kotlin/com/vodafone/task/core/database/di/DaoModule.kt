package com.vodafone.task.core.database.di

import com.vodafone.task.core.database.VodafoneTaskDatabase
import com.vodafone.task.core.database.dao.CityDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object DaoModule {

    @Singleton
    @Provides
    fun provideCityDao(database: VodafoneTaskDatabase): CityDao =
        database.cityDao()

}