package com.swapi.app.domain.usecase

import com.swapi.app.domain.model.Starship
import com.swapi.app.domain.repository.StarshipRepository
import javax.inject.Inject

class GetStarshipsUseCase @Inject constructor(
    private val repository: StarshipRepository
) {
    suspend operator fun invoke(page: Int = 1): List<Starship> = repository.getStarships(page)
}
