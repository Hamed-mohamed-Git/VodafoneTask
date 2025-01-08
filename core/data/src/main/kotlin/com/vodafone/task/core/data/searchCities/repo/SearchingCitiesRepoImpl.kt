package com.vodafone.task.core.data.searchCities.repo

import com.vodafone.task.core.common.map
import com.vodafone.task.core.common.onSuccess
import com.vodafone.task.core.data.searchCities.mapper.asCity
import com.vodafone.task.core.data.searchCities.mapper.asCityEntity
import com.vodafone.task.core.database.dao.CityDao
import com.vodafone.task.core.database.model.CityEntity
import com.vodafone.task.core.model.city.City
import com.vodafone.task.core.model.city.CitySearchingRequest
import com.vodafone.task.core.network.datasource.VodafoneTaskCitySearchingNetworkDataSource
import com.vodafone.task.core.network.model.CityResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private typealias Request = CitySearchingRequest

internal class SearchingCitiesRepoImpl @Inject constructor(
    private val source: VodafoneTaskCitySearchingNetworkDataSource,
    private val dao: CityDao
) : SearchingCitiesRepo {

    override fun loadLastSearchedCity(): Flow<List<City>> = dao
        .loadAllCities()
        .map(List<CityEntity>::asCity)

    override suspend fun fetchCities(request: Request): Resource = source
        .fetchCitiesBy(request)
        .onSuccess { insertCity(it) }
        .map(List<CityResponse>::asCity)

    private suspend fun insertCity(city: List<CityResponse>) = city
        .map(CityResponse::asCityEntity)
        .toTypedArray()
        .let { dao.insert(*it) }

}