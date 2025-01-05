package com.vodafone.task.core.data.di

import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepo
import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepoImpl
import com.vodafone.task.core.data.weather.repo.WeatherRepo
import com.vodafone.task.core.data.weather.repo.WeatherRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ReposModule {

    @Singleton
    @Binds
    internal abstract fun bindsWeatherModule(
        repo: WeatherRepoImpl
    ): WeatherRepo

    @Singleton
    @Binds
    internal abstract fun bindsSearchingCities(
        repo: SearchingCitiesRepoImpl
    ): SearchingCitiesRepo

}