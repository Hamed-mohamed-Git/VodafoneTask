package com.vodafone.task.core.utils.di

import com.vodafone.task.core.utils.NetworkMonitor
import com.vodafone.task.core.utils.ConnectivityManagerNetworkMonitor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class UtilsModule {

    @Singleton
    @Binds
    internal abstract fun bindsNetworkMonitor(
        monitor: ConnectivityManagerNetworkMonitor
    ): NetworkMonitor

}