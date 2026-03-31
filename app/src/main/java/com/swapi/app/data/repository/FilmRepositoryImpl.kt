package com.swapi.app.data.repository

import com.swapi.app.data.local.dao.FilmDao
import com.swapi.app.data.mapper.toDomain
import com.swapi.app.data.mapper.toEntity
import com.swapi.app.data.remote.SwapiApi
import com.swapi.app.domain.model.Film
import com.swapi.app.domain.repository.FilmRepository
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val api: SwapiApi,
    private val dao: FilmDao
) : FilmRepository {

    override suspend fun getFilms(): List<Film> {
        return try {
            val response = api.getFilms()
            val entities = response.results.map { it.toEntity() }
            dao.insertAll(entities)
            entities.map { it.toDomain() }
        } catch (e: Exception) {
            dao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getFilmById(id: Int): Film? {
        return try {
            api.getFilm(id).toDomain()
        } catch (e: Exception) {
            dao.getById(id)?.toDomain()
        }
    }
}
