package com.swapi.app.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.swapi.app.data.local.dao.FilmDao
import com.swapi.app.data.local.dao.PersonDao
import com.swapi.app.data.local.dao.PlanetDao
import com.swapi.app.data.local.dao.StarshipDao
import com.swapi.app.data.local.entity.FilmEntity
import com.swapi.app.data.local.entity.PersonEntity
import com.swapi.app.data.local.entity.PlanetEntity
import com.swapi.app.data.local.entity.StarshipEntity

@Database(
    entities = [PersonEntity::class, PlanetEntity::class, FilmEntity::class, StarshipEntity::class],
    version = 1,
    exportSchema = false
)
abstract class SwapiDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao
    abstract fun planetDao(): PlanetDao
    abstract fun filmDao(): FilmDao
    abstract fun starshipDao(): StarshipDao
}
