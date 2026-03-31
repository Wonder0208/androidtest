package com.swapi.app.data.remote

import com.swapi.app.data.remote.dto.FilmDto
import com.swapi.app.data.remote.dto.PagedResponse
import com.swapi.app.data.remote.dto.PersonDto
import com.swapi.app.data.remote.dto.PlanetDto
import com.swapi.app.data.remote.dto.StarshipDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface SwapiApi {

    @GET("people/")
    suspend fun getPeople(@Query("page") page: Int = 1): PagedResponse<PersonDto>

    @GET("people/{id}/")
    suspend fun getPerson(@Path("id") id: Int): PersonDto

    @GET("planets/")
    suspend fun getPlanets(@Query("page") page: Int = 1): PagedResponse<PlanetDto>

    @GET("planets/{id}/")
    suspend fun getPlanet(@Path("id") id: Int): PlanetDto

    @GET("films/")
    suspend fun getFilms(): PagedResponse<FilmDto>

    @GET("films/{id}/")
    suspend fun getFilm(@Path("id") id: Int): FilmDto

    @GET("starships/")
    suspend fun getStarships(@Query("page") page: Int = 1): PagedResponse<StarshipDto>

    @GET("starships/{id}/")
    suspend fun getStarship(@Path("id") id: Int): StarshipDto
}
