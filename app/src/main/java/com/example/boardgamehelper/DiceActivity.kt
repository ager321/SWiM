package com.example.boardgamehelper

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import kotlin.random.Random

class DiceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dice)

        val spinner: Spinner = findViewById(R.id.spinner)
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.dices_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }


        spinner?.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position)
                if (selectedItem == "1 dice") {
                    findViewById<TextView>(R.id.dice1).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice2).apply {
                        visibility = View.INVISIBLE
                    }
                    findViewById<TextView>(R.id.dice3).apply {
                        visibility = View.INVISIBLE
                    }
                    findViewById<TextView>(R.id.dice4).apply {
                        visibility = View.INVISIBLE
                    }
                } else if (selectedItem == "2 dices") {
                    findViewById<TextView>(R.id.dice1).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice2).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice3).apply {
                        visibility = View.INVISIBLE
                    }
                    findViewById<TextView>(R.id.dice4).apply {
                        visibility = View.INVISIBLE
                    }

                } else if (selectedItem == "3 dices") {
                    findViewById<TextView>(R.id.dice1).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice2).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice3).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice4).apply {
                        visibility = View.INVISIBLE
                    }

                } else if (selectedItem == "4 dices") {
                    findViewById<TextView>(R.id.dice1).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice2).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice3).apply {
                        visibility = View.VISIBLE
                    }
                    findViewById<TextView>(R.id.dice4).apply {
                        visibility = View.VISIBLE
                    }

                }
            }

        }



    }



    fun diceRoll(view: View){
        val randomValues = List(4) { Random.nextInt(1, 7) }
        findViewById<TextView>(R.id.dice1).apply {
            text = randomValues[0].toString()
        }
        findViewById<TextView>(R.id.dice2).apply {
            text = randomValues[1].toString()
        }
        findViewById<TextView>(R.id.dice3).apply {
            text = randomValues[2].toString()
        }
        findViewById<TextView>(R.id.dice4).apply {
            text = randomValues[3].toString()
        }
    }
}
