package com.example.boardgamehelper


import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun swichToVirtualDice(view: View) {
        val intent = Intent(this, DiceActivity::class.java)
        startActivity(intent)
    }
    fun swichToStarRealmsHelper(view: View) {
        val intent = Intent(this, StarRealmsHelper::class.java)
        startActivity(intent)
    }


    fun buttonSoonOnClick(view: View)
    {
        Toast.makeText(this@MainActivity, R.string.soon_toast_text, Toast.LENGTH_SHORT).show()
    }

}

