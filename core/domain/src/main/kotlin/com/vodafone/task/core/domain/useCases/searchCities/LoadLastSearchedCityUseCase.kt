package com.vodafone.task.core.domain.useCases.searchCities

import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepo
import com.vodafone.task.core.model.city.City
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

typealias LastSearchedUseCaseType = () -> Flow<List<City>>

internal class LoadLastSearchedCityUseCase @Inject constructor(
    private val repo: SearchingCitiesRepo
): LastSearchedUseCaseType {

    override fun invoke(): Flow<List<City>> = repo
        .loadLastSearchedCity()

}
