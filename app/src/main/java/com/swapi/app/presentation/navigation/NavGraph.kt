package com.swapi.app.presentation.navigation

sealed class Screen(val route: String) {
    object People : Screen("people")
    object PersonDetail : Screen("person/{personId}") {
        fun createRoute(id: Int) = "person/$id"
    }
    object Planets : Screen("planets")
    object PlanetDetail : Screen("planet/{planetId}") {
        fun createRoute(id: Int) = "planet/$id"
    }
    object Films : Screen("films")
    object FilmDetail : Screen("film/{filmId}") {
        fun createRoute(id: Int) = "film/$id"
    }
    object Starships : Screen("starships")
    object StarshipDetail : Screen("starship/{starshipId}") {
        fun createRoute(id: Int) = "starship/$id"
    }
}
