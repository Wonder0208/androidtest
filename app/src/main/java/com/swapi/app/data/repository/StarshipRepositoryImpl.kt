package com.swapi.app.data.repository

import com.swapi.app.data.local.dao.StarshipDao
import com.swapi.app.data.mapper.toDomain
import com.swapi.app.data.mapper.toEntity
import com.swapi.app.data.remote.SwapiApi
import com.swapi.app.domain.model.Starship
import com.swapi.app.domain.repository.StarshipRepository
import javax.inject.Inject

class StarshipRepositoryImpl @Inject constructor(
    private val api: SwapiApi,
    private val dao: StarshipDao
) : StarshipRepository {

    override suspend fun getStarships(page: Int): List<Starship> {
        return try {
            val response = api.getStarships(page)
            val entities = response.results.map { it.toEntity() }
            dao.insertAll(entities)
            entities.map { it.toDomain() }
        } catch (e: Exception) {
            dao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getStarshipById(id: Int): Starship? {
        return try {
            api.getStarship(id).toDomain()
        } catch (e: Exception) {
            dao.getById(id)?.toDomain()
        }
    }
}
