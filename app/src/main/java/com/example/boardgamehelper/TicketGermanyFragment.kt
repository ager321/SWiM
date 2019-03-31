package com.example.boardgamehelper

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class TicketGermanyFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.ticket_germany_fragment, container, false)


        return view
    }

    companion object {
        private val TAG = "Germany"
    }
}