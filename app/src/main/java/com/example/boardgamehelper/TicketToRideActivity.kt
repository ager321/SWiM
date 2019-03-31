package com.example.boardgamehelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class TicketToRideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticket_to_ride)
        setSupportActionBar(findViewById(R.id.main_activity_toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }
}
