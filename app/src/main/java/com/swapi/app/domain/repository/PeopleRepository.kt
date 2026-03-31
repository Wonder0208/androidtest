package com.swapi.app.domain.repository

import com.swapi.app.domain.model.Person

interface PeopleRepository {
    suspend fun getPeople(page: Int): List<Person>
    suspend fun getPersonById(id: Int): Person?
}
