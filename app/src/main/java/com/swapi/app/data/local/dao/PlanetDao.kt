package com.swapi.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swapi.app.data.local.entity.PlanetEntity

@Dao
interface PlanetDao {
    @Query("SELECT * FROM planets ORDER BY id ASC")
    suspend fun getAll(): List<PlanetEntity>

    @Query("SELECT * FROM planets WHERE id = :id")
    suspend fun getById(id: Int): PlanetEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(planets: List<PlanetEntity>)
}
