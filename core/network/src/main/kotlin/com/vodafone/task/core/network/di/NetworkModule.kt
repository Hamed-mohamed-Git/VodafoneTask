package com.vodafone.task.core.network.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.engine.HttpClientEngine
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideKtorClient(engine: HttpClientEngine) = ktorClient(engine)

    @Singleton
    @Provides
    fun provideKtorEngin(context: Context) = httpClientEngine(context)

}