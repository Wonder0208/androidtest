package com.swapi.app.data.mapper

import com.swapi.app.data.local.entity.StarshipEntity
import com.swapi.app.data.remote.dto.StarshipDto
import com.swapi.app.domain.model.Starship

fun StarshipDto.toEntity(): StarshipEntity {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return StarshipEntity(
        id = id,
        name = name,
        model = model,
        manufacturer = manufacturer,
        starshipClass = starshipClass,
        crew = crew,
        passengers = passengers,
        maxAtmospheringSpeed = maxAtmospheringSpeed,
        hyperdriveRating = hyperdriveRating
    )
}

fun StarshipEntity.toDomain() = Starship(
    id = id,
    name = name,
    model = model,
    manufacturer = manufacturer,
    starshipClass = starshipClass,
    crew = crew,
    passengers = passengers,
    maxAtmospheringSpeed = maxAtmospheringSpeed,
    hyperdriveRating = hyperdriveRating
)

fun StarshipDto.toDomain(): Starship {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return Starship(
        id = id,
        name = name,
        model = model,
        manufacturer = manufacturer,
        starshipClass = starshipClass,
        crew = crew,
        passengers = passengers,
        maxAtmospheringSpeed = maxAtmospheringSpeed,
        hyperdriveRating = hyperdriveRating
    )
}
