package com.swapi.app.data.mapper

import com.swapi.app.data.local.entity.PlanetEntity
import com.swapi.app.data.remote.dto.PlanetDto
import com.swapi.app.domain.model.Planet

fun PlanetDto.toEntity(): PlanetEntity {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return PlanetEntity(
        id = id,
        name = name,
        climate = climate,
        terrain = terrain,
        population = population,
        diameter = diameter,
        gravity = gravity,
        orbitalPeriod = orbitalPeriod,
        rotationPeriod = rotationPeriod
    )
}

fun PlanetEntity.toDomain() = Planet(
    id = id,
    name = name,
    climate = climate,
    terrain = terrain,
    population = population,
    diameter = diameter,
    gravity = gravity,
    orbitalPeriod = orbitalPeriod,
    rotationPeriod = rotationPeriod
)

fun PlanetDto.toDomain(): Planet {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return Planet(
        id = id,
        name = name,
        climate = climate,
        terrain = terrain,
        population = population,
        diameter = diameter,
        gravity = gravity,
        orbitalPeriod = orbitalPeriod,
        rotationPeriod = rotationPeriod
    )
}
