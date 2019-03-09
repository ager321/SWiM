package com.example.boardgamehelper


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun swichToVirtualDice(view: View) {
        val intent = Intent(this, DiceActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE,"zmaina")
        }
        startActivity(intent)
    }


}

