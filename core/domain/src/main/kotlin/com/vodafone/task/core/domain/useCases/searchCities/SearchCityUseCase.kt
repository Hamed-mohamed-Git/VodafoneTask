package com.vodafone.task.core.domain.useCases.searchCities

import com.vodafone.task.core.data.searchCities.repo.Resource
import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepo
import com.vodafone.task.core.model.city.CitySearchingRequest
import javax.inject.Inject

fun interface SearchCityUseCaseType {
    suspend operator fun invoke(request: CitySearchingRequest): Resource
}

internal class SearchCityUseCase @Inject constructor(
    private val repo: SearchingCitiesRepo
): SearchCityUseCaseType {

    override suspend operator fun invoke(request: CitySearchingRequest) =
        repo.fetchCities(request)

}