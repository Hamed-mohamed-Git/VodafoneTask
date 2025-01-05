package com.vodafone.task.core.network.di

import com.vodafone.task.core.network.datasource.VodafoneTaskCitySearchingNetworkDataSource
import com.vodafone.task.core.network.datasource.VodafoneTaskWeatherNetworkDataSource
import com.vodafone.task.core.network.ktor.datasoure.KtorCitySearchingNetworkDataSource
import com.vodafone.task.core.network.ktor.datasoure.KtorWeatherNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourcesModule {

    @Singleton
    @Binds
    internal abstract fun bindsWeatherDataSource(
        source: KtorWeatherNetworkDataSource
    ): VodafoneTaskWeatherNetworkDataSource

    @Singleton
    @Binds
    internal abstract fun bindsCitySearchingDataSource(
        source: KtorCitySearchingNetworkDataSource
    ): VodafoneTaskCitySearchingNetworkDataSource

}