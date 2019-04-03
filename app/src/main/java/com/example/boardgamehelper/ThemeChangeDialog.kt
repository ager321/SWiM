package com.example.boardgamehelper

import android.app.Activity
import android.content.*
import android.graphics.Color.BLUE
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_star_realms_helper.*

class ThemeChangeDialog : DialogFragment() {

    private var content: String? = null
    private var button_ref: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString("content")
        val style = DialogFragment.STYLE_NO_FRAME
        val theme = R.style.DialogTheme
        setStyle(style, theme)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.layout_dialog, container, false)

        val btnCancel = view.findViewById<View>(R.id.buttonCancel) as Button
        val btnAccept = view.findViewById<View>(R.id.buttonAccept) as Button

        val textViewContent = view.findViewById<View>(R.id.textViewContent) as TextView
        textViewContent.text = content


        btnCancel.setOnClickListener {
            Toast.makeText(activity, "action cancelled", Toast.LENGTH_SHORT).show()
            dismiss()
        }

        btnAccept.setOnClickListener {
            Toast.makeText(activity, "User Accepted Action", Toast.LENGTH_SHORT).show()
            activity?.change_theme_frg?.setBackgroundColor(BLUE)
            dismiss()
        }

        return view
    }

    companion object {
        fun newInstance(content: String): ThemeChangeDialog {
            val f = ThemeChangeDialog()
            val args = Bundle()
            args.putString("content", content)
            f.arguments = args
            return f
        }
    }

}