package com.vodafone.task.core.network.datasource

import com.vodafone.task.core.model.city.CitySearchingRequest
import com.vodafone.task.core.model.VodafoneTaskResource
import com.vodafone.task.core.network.model.CityResponse

interface VodafoneTaskCitySearchingNetworkDataSource {
    suspend fun fetchCitiesBy(request: CitySearchingRequest): VodafoneTaskResource<List<CityResponse>>
}