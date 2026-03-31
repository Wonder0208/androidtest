package com.swapi.app.data.mapper

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.swapi.app.data.local.entity.PersonEntity
import com.swapi.app.data.remote.dto.PersonDto
import com.swapi.app.domain.model.Person

private val gson = Gson()

fun PersonDto.toEntity(): PersonEntity {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return PersonEntity(
        id = id,
        name = name,
        birthYear = birthYear,
        gender = gender,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        homeworld = homeworld,
        films = gson.toJson(films),
        species = gson.toJson(species)
    )
}

fun PersonEntity.toDomain(): Person {
    val filmType = object : TypeToken<List<String>>() {}.type
    return Person(
        id = id,
        name = name,
        birthYear = birthYear,
        gender = gender,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        homeworld = homeworld,
        films = gson.fromJson(films, filmType),
        species = gson.fromJson(species, filmType)
    )
}

fun PersonDto.toDomain(): Person {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return Person(
        id = id,
        name = name,
        birthYear = birthYear,
        gender = gender,
        height = height,
        mass = mass,
        hairColor = hairColor,
        skinColor = skinColor,
        eyeColor = eyeColor,
        homeworld = homeworld,
        films = films,
        species = species
    )
}
