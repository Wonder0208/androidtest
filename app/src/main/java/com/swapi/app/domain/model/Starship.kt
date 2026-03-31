package com.swapi.app.domain.model

data class Starship(
    val id: Int,
    val name: String,
    val model: String,
    val manufacturer: String,
    val starshipClass: String,
    val crew: String,
    val passengers: String,
    val maxAtmospheringSpeed: String,
    val hyperdriveRating: String
)
