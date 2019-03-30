package com.example.boardgamehelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import android.widget.ImageView


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
    }
}
