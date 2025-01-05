package com.vodafone.task.core.domain.di

import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepo
import com.vodafone.task.core.data.weather.repo.WeatherRepo
import com.vodafone.task.core.domain.useCases.searchCities.SearchCityUseCase
import com.vodafone.task.core.domain.useCases.weather.GetWeatherUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewScoped

@Module
@InstallIn(ViewModelComponent::class)
object UseCasesModule {

    @Provides
    @ViewScoped
    fun provideWeatherUseCase(repo: WeatherRepo) = GetWeatherUseCase(repo)

    @Provides
    @ViewScoped
    fun provideSearchCityUseCase(repo: SearchingCitiesRepo) = SearchCityUseCase(repo)

}