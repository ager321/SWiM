package com.example.boardgamehelper

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_highscores.*

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
        setupListView(db)
       // addDefaultScores(db)
        findViewById<Button>(R.id.add_score_button).setOnClickListener{
            val tag = findViewById<EditText>(R.id.edit_name).text.toString()
            val score: Int = Integer.parseInt(findViewById<EditText>(R.id.edit_score).text.toString())
            db.playerDao().insertAll(PlayerEnum(0, tag, score))
            setupListView(db)
        }

    }


    private fun resetScores(db: AppDatabase) {
            for (player in db.playerDao().getAll()) {
                db.playerDao().delete(player)
            }
    }
    private fun setupListView(db: AppDatabase){
        val highscores_list = db.playerDao().getBestTen()
        val myAdapter = MyArrayAdapter(this, highscores_list)
        findViewById<ListView>(R.id.highscores_list_view).adapter = myAdapter
    }
    private fun addDefaultScores(db: AppDatabase) {
        db.playerDao().insertAll(   PlayerEnum(0,"Ager",150),
                                    PlayerEnum(0,"Clint Eastwood",200),
                                    PlayerEnum(0,"Defik",210),
                                    PlayerEnum(0,"Morgan",220),
                                    PlayerEnum(0,"Mitolog",230),
                                    PlayerEnum(0,"Ewok",230),
                                    PlayerEnum(0,"Gracz1",210),
                                    PlayerEnum(0,"Gracz1",300),
                                    PlayerEnum(0,"Gracz1",100),
                                    PlayerEnum(0,"Gracz1",20)
            )
    }

}
