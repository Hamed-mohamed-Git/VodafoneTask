package com.vodafone.task.core.domain.useCases.searchCities

import com.vodafone.task.core.data.searchCities.repo.SearchingCitiesRepo
import com.vodafone.task.core.model.city.CitySearchingRequest
import javax.inject.Inject

class SearchCityUseCase @Inject internal constructor(private val repo: SearchingCitiesRepo) {

    operator fun invoke(request: CitySearchingRequest) = repo
        .fetchCities(request)

}