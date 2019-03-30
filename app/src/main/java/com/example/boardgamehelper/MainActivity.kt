package com.example.boardgamehelper


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        configureSoonButton()
        setSupportActionBar(findViewById(R.id.main_activity_toolbar))
    }

    private fun configureSoonButton() {

        val button: Button = findViewById(R.id.soon_button)
        button.setOnLongClickListener {
            Toast.makeText(this@MainActivity, R.string.two_weeks_toast_text, Toast.LENGTH_LONG).show()
            true
        }
    }


    fun swichToVirtualDice(view: View) {
        val intent = Intent(this, DiceActivity::class.java)
        startActivity(intent)
    }

    fun swichToStarRealmsHelper(view: View) {
        val intent = Intent(this, StarRealmsHelper::class.java)
        startActivity(intent)
    }


    fun buttonSoonOnClick(view: View) {
        Toast.makeText(this@MainActivity, R.string.soon_toast_text, Toast.LENGTH_SHORT).show()
    }


}

