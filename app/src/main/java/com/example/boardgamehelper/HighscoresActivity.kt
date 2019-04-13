package com.example.boardgamehelper

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class HighscoresActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_highscores)
        val dbbuilder = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        )
        dbbuilder.allowMainThreadQueries()
        val db = dbbuilder.build()
        db.playerDao().insertAll(PlayerEnum(0,"ab",100),PlayerEnum(0,"aaab",120))
    }

    private fun resetScores(db: AppDatabase) {
            for (player in db.playerDao().getAll()) {
                db.playerDao().delete(player)
            }
    }
    private fun addDefaultScores(db: AppDatabase) {
        db.playerDao().insertAll()
    }

}
