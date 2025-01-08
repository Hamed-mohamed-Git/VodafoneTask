package com.vodafone.task.core.domain.di

import com.vodafone.task.core.domain.useCases.searchCities.LastSearchedUseCaseType
import com.vodafone.task.core.domain.useCases.searchCities.LoadLastSearchedCityUseCase
import com.vodafone.task.core.domain.useCases.searchCities.SearchCityUseCase
import com.vodafone.task.core.domain.useCases.searchCities.SearchCityUseCaseType
import com.vodafone.task.core.domain.useCases.weather.GetWeatherUseCase
import com.vodafone.task.core.domain.useCases.weather.GetWeatherUseCaseType
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCasesModule {

    @Binds
    @ViewModelScoped
    internal abstract fun bindsGetWeatherUseCase(
        useCase: GetWeatherUseCase
    ): GetWeatherUseCaseType

    @Binds
    @ViewModelScoped
    internal abstract fun bindsSearchCityUseCase(
        useCase: SearchCityUseCase
    ): SearchCityUseCaseType

    @Binds
    @ViewModelScoped
    internal abstract fun bindsLoadLastSearchedCityUseCase(
        useCase: LoadLastSearchedCityUseCase
    ): LastSearchedUseCaseType

}