package com.swapi.app.domain.usecase

import com.swapi.app.domain.model.Film
import com.swapi.app.domain.repository.FilmRepository
import javax.inject.Inject

class GetFilmsUseCase @Inject constructor(
    private val repository: FilmRepository
) {
    suspend operator fun invoke(): List<Film> = repository.getFilms()
}
