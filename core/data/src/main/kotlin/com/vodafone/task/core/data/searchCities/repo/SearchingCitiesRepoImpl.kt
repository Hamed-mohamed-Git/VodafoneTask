package com.vodafone.task.core.data.searchCities.repo

import com.vodafone.task.core.utils.NetworkMonitor
import com.vodafone.task.core.common.getOrThrow
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
    private val dao: CityDao,
    private val networkMonitor: NetworkMonitor
) : SearchingCitiesRepo {

    override fun fetchCities(request: Request): Flow<List<City>> = networkMonitor
        .isOnline
        .map {
            if (it) fetchAndCacheCities(request)
            else loadCity()
        }

    private suspend fun fetchAndCacheCities(request: Request) = source
        .fetchCitiesBy(request)
        .map(List<CityResponse>::asCity)
        .onSuccess { insertCity(it) }
        .getOrThrow()

    private suspend fun insertCity(city: List<City>) = city
        .map(City::asCityEntity)
        .toTypedArray()
        .let { dao.insert(*it) }

    private suspend fun loadCity() = dao
        .loadAllCities()
        .map(CityEntity::asCity)

}