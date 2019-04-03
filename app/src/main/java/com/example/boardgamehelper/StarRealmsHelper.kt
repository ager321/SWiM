package com.example.boardgamehelper

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Color.RED
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_star_realms_helper.*


class StarRealmsHelper : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_star_realms_helper)
        val imageBlob = findViewById<ImageView>(R.id.blob_picture)

        Glide.with(this)
            .load("http://www.sclance.com/pngs/256x256-png/256x256_png_4667.png") // image url
            .placeholder(R.drawable.black_dice_256) // any placeholder to load at start
            .override(256, 256) // resizing
            .into(imageBlob)


        change_theme.setOnClickListener{
            // Initialize a new instance of
            val builder = AlertDialog.Builder(this@StarRealmsHelper)
            builder.setTitle("Button background color")
            builder.setMessage("Are you want to set the button background color to RED?")

            builder.setPositiveButton("YES"){dialog, which ->
                change_theme.setBackgroundColor(RED)
            }

            builder.setNegativeButton("No"){dialog,which ->
                Toast.makeText(applicationContext,"You are not agree.",Toast.LENGTH_SHORT).show()
            }
            builder.setNeutralButton("Cancel"){_,_ ->
                Toast.makeText(applicationContext,"You cancelled the dialog.",Toast.LENGTH_SHORT).show()
            }
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

        button.setOnClickListener {
        }
        val ft = getSupportFragmentManager().beginTransaction()
        val newFragment = ThemeChangeDialog.newInstance("content")
        newFragment.show(ft, "dialog")

    }

}

