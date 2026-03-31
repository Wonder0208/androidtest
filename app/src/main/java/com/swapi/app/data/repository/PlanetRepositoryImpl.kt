package com.swapi.app.data.repository

import com.swapi.app.data.local.dao.PlanetDao
import com.swapi.app.data.mapper.toDomain
import com.swapi.app.data.mapper.toEntity
import com.swapi.app.data.remote.SwapiApi
import com.swapi.app.domain.model.Planet
import com.swapi.app.domain.repository.PlanetRepository
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
    private val api: SwapiApi,
    private val dao: PlanetDao
) : PlanetRepository {

    override suspend fun getPlanets(page: Int): List<Planet> {
        return try {
            val response = api.getPlanets(page)
            val entities = response.results.map { it.toEntity() }
            dao.insertAll(entities)
            entities.map { it.toDomain() }
        } catch (e: Exception) {
            dao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getPlanetById(id: Int): Planet? {
        return try {
            api.getPlanet(id).toDomain()
        } catch (e: Exception) {
            dao.getById(id)?.toDomain()
        }
    }
}
