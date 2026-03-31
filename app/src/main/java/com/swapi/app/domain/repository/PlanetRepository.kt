package com.swapi.app.domain.repository

import com.swapi.app.domain.model.Planet

interface PlanetRepository {
    suspend fun getPlanets(page: Int): List<Planet>
    suspend fun getPlanetById(id: Int): Planet?
}
