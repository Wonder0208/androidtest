package com.swapi.app.di

import android.content.Context
import androidx.room.Room
import com.swapi.app.data.local.SwapiDatabase
import com.swapi.app.data.local.dao.FilmDao
import com.swapi.app.data.local.dao.PersonDao
import com.swapi.app.data.local.dao.PlanetDao
import com.swapi.app.data.local.dao.StarshipDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): SwapiDatabase =
        Room.databaseBuilder(context, SwapiDatabase::class.java, "swapi.db").build()

    @Provides fun providePersonDao(db: SwapiDatabase): PersonDao = db.personDao()
    @Provides fun providePlanetDao(db: SwapiDatabase): PlanetDao = db.planetDao()
    @Provides fun provideFilmDao(db: SwapiDatabase): FilmDao = db.filmDao()
    @Provides fun provideStarshipDao(db: SwapiDatabase): StarshipDao = db.starshipDao()
}
