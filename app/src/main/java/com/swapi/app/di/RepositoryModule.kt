package com.swapi.app.di

import com.swapi.app.data.repository.FilmRepositoryImpl
import com.swapi.app.data.repository.PeopleRepositoryImpl
import com.swapi.app.data.repository.PlanetRepositoryImpl
import com.swapi.app.data.repository.StarshipRepositoryImpl
import com.swapi.app.domain.repository.FilmRepository
import com.swapi.app.domain.repository.PeopleRepository
import com.swapi.app.domain.repository.PlanetRepository
import com.swapi.app.domain.repository.StarshipRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds @Singleton
    abstract fun bindPeopleRepository(impl: PeopleRepositoryImpl): PeopleRepository

    @Binds @Singleton
    abstract fun bindPlanetRepository(impl: PlanetRepositoryImpl): PlanetRepository

    @Binds @Singleton
    abstract fun bindFilmRepository(impl: FilmRepositoryImpl): FilmRepository

    @Binds @Singleton
    abstract fun bindStarshipRepository(impl: StarshipRepositoryImpl): StarshipRepository
}
