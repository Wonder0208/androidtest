package com.swapi.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class PlanetDto(
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    val diameter: String,
    val gravity: String,
    @SerializedName("orbital_period") val orbitalPeriod: String,
    @SerializedName("rotation_period") val rotationPeriod: String,
    val url: String
)
