package com.swapi.app.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "starships")
data class StarshipEntity(
    @PrimaryKey val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val starshipClass: String,
    val crew: String,
    val passengers: String,
    val maxAtmospheringSpeed: String,
    val hyperdriveRating: String
)
