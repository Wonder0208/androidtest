package com.swapi.app.data.mapper

import com.swapi.app.data.local.entity.FilmEntity
import com.swapi.app.data.remote.dto.FilmDto
import com.swapi.app.domain.model.Film

fun FilmDto.toEntity(): FilmEntity {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return FilmEntity(
        id = id,
        title = title,
        episodeId = episodeId,
        director = director,
        producer = producer,
        releaseDate = releaseDate,
        openingCrawl = openingCrawl
    )
}

fun FilmEntity.toDomain() = Film(
    id = id,
    title = title,
    episodeId = episodeId,
    director = director,
    producer = producer,
    releaseDate = releaseDate,
    openingCrawl = openingCrawl
)

fun FilmDto.toDomain(): Film {
    val id = url.trimEnd('/').substringAfterLast('/').toIntOrNull() ?: 0
    return Film(
        id = id,
        title = title,
        episodeId = episodeId,
        director = director,
        producer = producer,
        releaseDate = releaseDate,
        openingCrawl = openingCrawl
    )
}
