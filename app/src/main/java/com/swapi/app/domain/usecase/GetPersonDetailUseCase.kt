package com.swapi.app.domain.usecase

import com.swapi.app.domain.model.Person
import com.swapi.app.domain.repository.PeopleRepository
import javax.inject.Inject

class GetPersonDetailUseCase @Inject constructor(
    private val repository: PeopleRepository
) {
    suspend operator fun invoke(id: Int): Person? = repository.getPersonById(id)
}
