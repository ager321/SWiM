package com.example.boardgamehelper


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.view.Menu
import android.widget.Button
import android.widget.Toast
import com.facebook.stetho.Stetho


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.main_activity_toolbar))
        Stetho.initializeWithDefaults(this);
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }


    fun swichToVirtualDice(view: View) {
        val intent = Intent(this, DiceActivity::class.java)
        startActivity(intent)
    }

    fun swichToStarRealmsHelper(view: View) {
        val intent = Intent(this, StarRealmsHelper::class.java)
        startActivity(intent)
    }
    fun switchToTicketToRide(view: View) {
        val intent = Intent(this, TicketToRideActivity::class.java)
        startActivity(intent)
    }
    fun switchToCamera(view: View) {
        val intent = Intent(this, Camera::class.java)
        startActivity(intent)
    }
    fun switchToHighscores(view: View) {
        val intent = Intent(this, HighscoresActivity::class.java)
        startActivity(intent)
    }


    fun buttonSoonOnClick(view: View) {
        Toast.makeText(this@MainActivity, R.string.soon_toast_text, Toast.LENGTH_SHORT).show()
    }
    private fun configureSoonButton() {

        val button: Button = findViewById(R.id.soon_button)
        button.setOnLongClickListener {
            Toast.makeText(this@MainActivity, R.string.two_weeks_toast_text, Toast.LENGTH_LONG).show()
            true
        }
    }

}

