package com.swapi.app.data.repository

import com.swapi.app.data.local.dao.PersonDao
import com.swapi.app.data.mapper.toDomain
import com.swapi.app.data.mapper.toEntity
import com.swapi.app.data.remote.SwapiApi
import com.swapi.app.domain.model.Person
import com.swapi.app.domain.repository.PeopleRepository
import javax.inject.Inject

class PeopleRepositoryImpl @Inject constructor(
    private val api: SwapiApi,
    private val dao: PersonDao
) : PeopleRepository {

    override suspend fun getPeople(page: Int): List<Person> {
        return try {
            val response = api.getPeople(page)
            val entities = response.results.map { it.toEntity() }
            dao.insertAll(entities)
            entities.map { it.toDomain() }
        } catch (e: Exception) {
            dao.getAll().map { it.toDomain() }
        }
    }

    override suspend fun getPersonById(id: Int): Person? {
        return try {
            api.getPerson(id).toDomain()
        } catch (e: Exception) {
            dao.getById(id)?.toDomain()
        }
    }
}
