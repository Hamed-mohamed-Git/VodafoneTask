package com.vodafone.task.core.data.searchCities.repo

import com.vodafone.task.core.model.city.City
import com.vodafone.task.core.model.city.CitySearchingRequest
import com.vodafone.task.core.network.VodafoneTaskResource
import kotlinx.coroutines.flow.Flow

interface SearchingCitiesRepo {
    fun fetchCities(request: CitySearchingRequest): Flow<List<City>>
}