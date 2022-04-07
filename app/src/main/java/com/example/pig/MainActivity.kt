package com.example.pig

import android.os.Bundle
import android.text.format.DateUtils.LENGTH_MEDIUM
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import java.util.*
import java.util.stream.Stream


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var player1 = Player()
        var player2 = Player()

        val rollPlayer1: Button = findViewById(R.id.Roll1)
        val rollPlayer2: Button = findViewById(R.id.Roll2)

        val endPlayer1: Button = findViewById(R.id.EndTurn1)
        val endPlayer2: Button = findViewById(R.id.EndTurn2)

        val restart: Button = findViewById(R.id.Restart)

        val pig1: Button = findViewById(R.id.Pig1)
        val pig2: Button = findViewById(R.id.Pig2)

        // listen for rolls


            // Player 1 rolls
            rollPlayer1.setOnClickListener {
                var diceRoll = player1.roll()
                val diceImage: ImageView = findViewById(R.id.Dice1)

                val drawableResource = when (diceRoll) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }

                diceImage.setImageResource(drawableResource)

                if (diceRoll == 1) {
                    player1.current_score = 0
                } else {
                    player1.current_score += diceRoll
                }
                var currentScore: TextView = findViewById(R.id.Score1Current)
                currentScore.setText("${player1.current_score}")
            }
            // End Player turn
            endPlayer1.setOnClickListener {

                player1.score += player1.current_score
                player1.current_score = 0
                var currentScore: TextView = findViewById(R.id.Score1Current)
                currentScore.setText("${player1.current_score}")
                var totalScore: TextView = findViewById(R.id.Score1Total)
                totalScore.setText("${player1.score}")
            }

            // Player 2 rolls
            rollPlayer2.setOnClickListener {
                var diceRoll = player2.roll()
                val diceImage: ImageView = findViewById(R.id.Dice2)

                val drawableResource = when (diceRoll) {
                    1 -> R.drawable.dice_1
                    2 -> R.drawable.dice_2
                    3 -> R.drawable.dice_3
                    4 -> R.drawable.dice_4
                    5 -> R.drawable.dice_5
                    else -> R.drawable.dice_6
                }

                diceImage.setImageResource(drawableResource)

                if (diceRoll == 1) {
                    player2.current_score = 0
                } else {
                    player2.current_score += diceRoll
                }
                var currentScore: TextView = findViewById(R.id.Score2Current)
                currentScore.setText("${player2.current_score}")
            }
            // End Player turn
            endPlayer2.setOnClickListener {

                player2.score += player2.current_score
                player2.current_score = 0
                var currentScore: TextView = findViewById(R.id.Score2Current)
                currentScore.setText("${player2.current_score}")
                var totalScore: TextView = findViewById(R.id.Score2Total)
                totalScore.setText("${player2.score}")
            }

            // Restart the Game
            restart.setOnClickListener {
                // Player 1 reset
                player1.current_score = 0
                player1.score = 0
                var currentScore: TextView = findViewById(R.id.Score1Current)
                currentScore.setText("${player1.current_score}")
                var totalScore: TextView = findViewById(R.id.Score1Total)
                totalScore.setText("${player1.score}")

                // Player 2 reset
                player2.score = 0
                player2.current_score = 0
                var currentScore2: TextView = findViewById(R.id.Score2Current)
                currentScore2.setText("${player2.current_score}")
                var totalScore2: TextView = findViewById(R.id.Score2Total)
                totalScore2.setText("${player2.score}")

            }


        pig1.setOnClickListener{

            // Toast for Player 1
            val text = "Player 1 Wins!"
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()

            // reset Player 1
            player1.current_score = 0
            player1.score = 0
            var currentScore: TextView = findViewById(R.id.Score1Current)
            currentScore.setText("${player1.current_score}")
            var totalScore: TextView = findViewById(R.id.Score1Total)
            totalScore.setText("${player1.score}")
            // Reset Player 2
            player2.score = 0
            player2.current_score = 0
            var currentScore2: TextView = findViewById(R.id.Score2Current)
            currentScore2.setText("${player2.current_score}")
            var totalScore2: TextView = findViewById(R.id.Score2Total)
            totalScore2.setText("${player2.score}")
        }

        pig2.setOnClickListener{

            // Toast for Player 2
            val text = "Player 2 Wins!"
            val duration = Toast.LENGTH_LONG

            val toast = Toast.makeText(applicationContext, text, duration)
            toast.show()
            // reset Player 1
            player1.current_score = 0
            player1.score = 0
            var currentScore: TextView = findViewById(R.id.Score1Current)
            currentScore.setText("${player1.current_score}")
            var totalScore: TextView = findViewById(R.id.Score1Total)
            totalScore.setText("${player1.score}")
            // Reset Player 2
            player2.score = 0
            player2.current_score = 0
            var currentScore2: TextView = findViewById(R.id.Score2Current)
            currentScore2.setText("${player2.current_score}")
            var totalScore2: TextView = findViewById(R.id.Score2Total)
            totalScore2.setText("${player2.score}")
        }




        }
    }



class Player() {
    var score = 0

    var current_score = 0

    fun bust (){
        current_score = 0
    }

    fun roll(): Int {
        return (1..6).random()
    }


}

