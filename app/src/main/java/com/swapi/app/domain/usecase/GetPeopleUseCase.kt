package com.swapi.app.domain.usecase

import com.swapi.app.domain.model.Person
import com.swapi.app.domain.repository.PeopleRepository
import javax.inject.Inject

class GetPeopleUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(page: Int = 1): List<Person> = repository.getPeople(page)
}
