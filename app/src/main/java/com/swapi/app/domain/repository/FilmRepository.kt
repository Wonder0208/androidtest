package com.swapi.app.domain.repository

import com.swapi.app.domain.model.Film

interface FilmRepository {
    suspend fun getFilms(): List<Film>
    suspend fun getFilmById(id: Int): Film?
}
