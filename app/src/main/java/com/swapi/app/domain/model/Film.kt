package com.swapi.app.domain.model

data class Film(
    val id: Int,
    val title: String,
    val episodeId: Int,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val openingCrawl: String
)
