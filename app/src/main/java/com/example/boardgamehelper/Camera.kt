package com.example.boardgamehelper

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.content.FileProvider
import android.widget.Button
import android.widget.ImageView
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.activity_camera.*


class Camera : AppCompatActivity() {

    val REQUEST_IMAGE_CAPTURE = 1
    lateinit var currentPhotoPath: String

    private var PREFS_NAME = "language"
    var lang : String? = "eng"
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        sharedPref = getSharedPreferences( PREFS_NAME, Context.MODE_PRIVATE)
        lang = sharedPref.getString("lang", "eng")
        if(lang.equals("eng")){
            take_photo_button.text = resources.getText(R.string.take_a_photo_eng)
            lang_switch.text = resources.getText(R.string.lang_switch_eng)
            lang_switch.isChecked = false
        }else{
            take_photo_button.text = resources.getText(R.string.take_a_photo_pl)
            lang_switch.text = resources.getText(R.string.lang_switch_pl)
            lang_switch.isChecked = true
        }
        findViewById<Button>(R.id.take_photo_button).setOnClickListener {
            dispatchTakePictureIntent()
        }
        lang_switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            if(!isChecked){
                lang = "eng"
                take_photo_button.text = resources.getText(R.string.take_a_photo_eng)
                lang_switch.text = resources.getText(R.string.lang_switch_eng)
            }
            else{
                lang = "pl"
                take_photo_button.text = resources.getText(R.string.take_a_photo_pl)
                lang_switch.text = resources.getText(R.string.lang_switch_pl)
            }
            sharedPref = getSharedPreferences( PREFS_NAME, Context.MODE_PRIVATE)
            val editor : SharedPreferences.Editor = sharedPref.edit()
            editor.putString("lang", lang)
            editor.apply()
        })
    }


    private fun dispatchTakePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { takePictureIntent ->
            takePictureIntent.resolveActivity(packageManager)?.also {
                val photoFile: File? = try {
                    createImageFile()
                } catch (ex: IOException) {
                    null
                }
                photoFile?.also {
                    val photoURI: Uri = FileProvider.getUriForFile(
                        this,
                        "com.example.android.fileprovider",
                        it
                    )
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
                }
            }
        }
    }
    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File? = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
            "JPEG_${timeStamp}_", /* prefix */
            ".jpg", /* suffix */
            storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            currentPhotoPath = absolutePath
        }
    }

}


