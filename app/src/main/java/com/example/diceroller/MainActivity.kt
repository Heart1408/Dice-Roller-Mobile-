package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val resultTextView: TextView = findViewById(R.id.textView)
        val myFirstDice = Dice(6)
        val rollResult = myFirstDice.roll()
        val luckyNumber = 4

        if (rollResult == luckyNumber) {
            resultTextView.text = "You win!"
        } else if (rollResult == 1) {
            resultTextView.text = "So sorry! You rolled a 1. Try again!"
        } else if (rollResult == 2) {
            resultTextView.text = "Sadly, you rolled a 2. Try again!"
        } else if (rollResult == 3) {
            resultTextView.text = "Unfortunately, you rolled a 3. Try again!"
        } else if (rollResult == 5) {
            resultTextView.text = "Don't cry! You rolled a 5. Try again!"
        } else {
            resultTextView.text = "Apologies! You rolled a 6. Try again!"
        }
    }
}