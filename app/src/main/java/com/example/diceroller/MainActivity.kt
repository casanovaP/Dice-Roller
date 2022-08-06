package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button in the layout
        val rollButton: Button = findViewById(R.id.button)

        // Set a click listener on the button to roll the dice when the user taps the button
        rollButton.setOnClickListener {
            rollDice()
        }

        // Do a dice roll when the app starts
        rollDice()
        main()
    }

    private fun rollDice() {
        // Create new Dice object with 6 sides and roll it
        val dice = Dice(6)
        val diceRoll = dice.roll()

        // Update the screen with the dice roll
        val diceImage: ImageView = findViewById(R.id.imageView)
        val drawableResource = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = diceRoll.toString()
    }

    class Dice(private val numSides: Int) {

        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private val myFirstDice = Dice(6)
    private val rollResult = myFirstDice.roll()
    private val luckyNumber = 3

    private fun main() {
        when (rollResult) {
            luckyNumber -> Toast.makeText(
                this@MainActivity,
                "You won!", Toast.LENGTH_SHORT)
                .show()
            1 -> Toast.makeText(
                this@MainActivity,
                "So sorry! You rolled a 1. Try again!",
                Toast.LENGTH_SHORT
            ).show()
            2 -> Toast.makeText(
                this@MainActivity,
                "Sadly, you rolled a 2. Try again!",
                Toast.LENGTH_SHORT
            ).show()
            3 -> Toast.makeText(
                this@MainActivity,
                "Unfortunately, you rolled a 3. Try again!",
                Toast.LENGTH_SHORT
            ).show()
            5 -> Toast.makeText(
                this@MainActivity,
                "Don't cry! You rolled a 5. Try again!",
                Toast.LENGTH_SHORT
            ).show()
            6 -> Toast.makeText(
                this@MainActivity,
                "Apologies! you rolled a 6. Try again!",
                Toast.LENGTH_SHORT
            ).show()

        }
    }
}

