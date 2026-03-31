package com.swapi.app.domain.repository

import com.swapi.app.domain.model.Starship

interface StarshipRepository {
    suspend fun getStarships(page: Int): List<Starship>
    suspend fun getStarshipById(id: Int): Starship?
}
