package com.swapi.app.domain.model

data class Person(
    val id: Int,
    val name: String,
    val birthYear: String,
    val gender: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val homeworld: String, // planet URL
    val films: List<String>,
    val species: List<String>
)
