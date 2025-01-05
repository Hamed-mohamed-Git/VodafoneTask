package com.vodafone.task.core.network.ktor.datasoure

import com.vodafone.task.core.model.city.CitySearchingRequest
import com.vodafone.task.core.network.BuildConfig
import com.vodafone.task.core.network.VodafoneNetworkPath
import com.vodafone.task.core.network.VodafoneTaskResource
import com.vodafone.task.core.network.datasource.VodafoneTaskCitySearchingNetworkDataSource
import com.vodafone.task.core.network.ktor.apiCall
import com.vodafone.task.core.network.model.CityResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import javax.inject.Inject

internal class KtorCitySearchingNetworkDataSource @Inject constructor(
    private val client: HttpClient
): VodafoneTaskCitySearchingNetworkDataSource {

    override suspend fun fetchCitiesBy(request: CitySearchingRequest): VodafoneTaskResource<List<CityResponse>> =
        client.apiCall {
            get(VodafoneNetworkPath.City.SEARCHING_CITY){
                parameter("cityName", request.cityName)
                parameter("limit", request.limit)
                parameter("apiKey", BuildConfig.API_KEY)
            }
        }
}