package com.example.boardgamehelper

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface PlayerDao {
    @Query("SELECT * FROM players ORDER BY id")
    fun getAll(): List<PlayerEnum>

    @Query("SELECT * FROM players WHERE high_score > 50 ORDER BY high_score LIMIT 10" )
    fun getBestTen(): List<PlayerEnum>

    @Insert
    fun insertAll(vararg users: PlayerEnum)

    @Delete
    fun delete(playerEnum: PlayerEnum)
}