package com.swapi.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.swapi.app.data.local.entity.StarshipEntity

@Dao
interface StarshipDao {
    @Query("SELECT * FROM starships ORDER BY id ASC")
    suspend fun getAll(): List<StarshipEntity>

    @Query("SELECT * FROM starships WHERE id = :id")
    suspend fun getById(id: Int): StarshipEntity?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(starships: List<StarshipEntity>)
}
