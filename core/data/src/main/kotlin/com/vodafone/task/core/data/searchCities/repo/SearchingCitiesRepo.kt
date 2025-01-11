package com.vodafone.task.core.data.searchCities.repo

import com.vodafone.task.core.model.city.City
import com.vodafone.task.core.model.city.CitySearchingRequest
import com.vodafone.task.core.model.VodafoneTaskResource
import kotlinx.coroutines.flow.Flow

typealias Resource = VodafoneTaskResource<List<City>>

interface SearchingCitiesRepo {
   fun loadLastSearchedCity(): Flow<List<City>>
   suspend fun fetchCities(request: CitySearchingRequest): Resource
}
