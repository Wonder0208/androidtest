package com.swapi.app.domain.usecase

import com.swapi.app.domain.model.Planet
import com.swapi.app.domain.repository.PlanetRepository
import javax.inject.Inject

class GetPlanetsUseCase @Inject constructor(
    private val repository: PlanetRepository
) {
    suspend operator fun invoke(page: Int = 1): List<Planet> = repository.getPlanets(page)
}
