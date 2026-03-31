package com.swapi.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "films")
data class FilmEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val episodeId: Int,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val openingCrawl: String
)
