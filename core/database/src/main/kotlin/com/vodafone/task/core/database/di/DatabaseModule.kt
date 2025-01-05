package com.vodafone.task.core.database.di

import android.content.Context
import androidx.room.Room
import com.vodafone.task.core.database.VodafoneTaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    internal fun provideDatabase(@ApplicationContext context: Context): VodafoneTaskDatabase = Room
        .databaseBuilder(context, VodafoneTaskDatabase::class.java, "vodafone-database")
        .build()

}