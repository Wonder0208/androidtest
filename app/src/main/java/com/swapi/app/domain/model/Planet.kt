package com.swapi.app.domain.model

data class Planet(
    val id: Int,
    val name: String,
    val climate: String,
    val terrain: String,
    val population: String,
    val diameter: String,
    val gravity: String,
    val orbitalPeriod: String,
    val rotationPeriod: String
)
