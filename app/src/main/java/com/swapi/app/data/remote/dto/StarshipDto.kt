package com.swapi.app.data.remote.dto

import com.google.gson.annotations.SerializedName

data class StarshipDto(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("starship_class") val starshipClass: String,
    val crew: String,
    val passengers: String,
    @SerializedName("max_atmosphering_speed") val maxAtmospheringSpeed: String,
    @SerializedName("hyperdrive_rating") val hyperdriveRating: String,
    val url: String
)
