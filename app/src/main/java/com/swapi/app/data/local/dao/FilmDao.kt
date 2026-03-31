package com.swapi.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swapi.app.data.local.entity.FilmEntity

@Dao
interface FilmDao {
    @Query("SELECT * FROM films ORDER BY episodeId ASC")
    suspend fun getAll(): List<FilmEntity>

    @Query("SELECT * FROM films WHERE id = :id")
    suspend fun getById(id: Int): FilmEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(films: List<FilmEntity>)
}
