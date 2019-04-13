package com.example.boardgamehelper

import android.arch.persistence.room.*

@Entity(tableName = "players")
data class PlayerEnum (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "game_tag") val gameTag: String,
    @ColumnInfo(name = "high_score") val highScore: Int
)