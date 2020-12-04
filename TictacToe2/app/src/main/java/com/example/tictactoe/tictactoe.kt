package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat

class tictactoe : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var resetButton: Button

    var clickCounter = 0

    private var activePlayer = 1

    private var firstPlayer = ArrayList<Int> ()
    private var secondPlayer = ArrayList<Int> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tictactoe)


        init()
    }

    private fun init() {

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        resetButton = findViewById(R.id.buttonRestart)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

    }

    override fun onClick(clickedView: View?) {

        if(clickedView is Button) {

            var buttonNumber = 0

            when (clickedView.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9

            }

            if(buttonNumber != 0) {

                playGame(clickedView, buttonNumber)



            }

        }

    }

    



    private fun playGame(clickedView: Button, buttonNumber: Int) {
        if(activePlayer == 1) {
            clickedView.text = "X"
            clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.ttgreen))
            clickedView.setTextColor(ContextCompat.getColor(this, R.color.ttpink))
            firstPlayer.add(buttonNumber)
            clickCounter+=1
            activePlayer = 2
        }
        else {
            clickedView.text = "O"
            clickedView.setBackgroundColor(ContextCompat.getColor(this, R.color.ttpink))
            clickedView.setTextColor(ContextCompat.getColor(this, R.color.ttgreen))
            secondPlayer.add(buttonNumber)
            clickCounter+=1
            activePlayer = 1
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check() {

        var winnerPlayer = 0


        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(8)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(2) && secondPlayer.contains(5) && secondPlayer.contains(8)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winnerPlayer = 2
        }



        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)) {
            winnerPlayer = 1
        }

        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)) {
            winnerPlayer = 2
        }

        if (winnerPlayer != 0) {
            if (winnerPlayer ==1) {
                Toast.makeText(this, "X Wins !!!", Toast.LENGTH_LONG).show()
            }
            else {
                Toast.makeText(this, "O Wins !!!", Toast.LENGTH_LONG).show()
            }

            disableButtons()
        }
        if (winnerPlayer == 0 && clickCounter == 9) {
            Toast.makeText(this, "DRAW!", Toast.LENGTH_LONG).show()
        }

    }

    private fun disableButtons() {

        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false

    }

    private fun enableButtons() {
        button1.isEnabled = true
        button2.isEnabled = true
        button3.isEnabled = true
        button4.isEnabled = true
        button5.isEnabled = true
        button6.isEnabled = true
        button7.isEnabled = true
        button8.isEnabled = true
        button9.isEnabled = true
    }

    fun resetButton(view: View) {
        firstPlayer.clear()
        secondPlayer.clear()
        activePlayer = 1
        enableButtons()
        resetBackground()
        resetCounter()
    }

    private fun resetBackground() {

        button1.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button2.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button3.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button4.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button5.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button6.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button7.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button8.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))
        button9.setBackgroundColor(ContextCompat.getColor(this, R.color.ttorange))

        button1.setText("")
        button2.setText("")
        button3.setText("")
        button4.setText("")
        button5.setText("")
        button6.setText("")
        button7.setText("")
        button8.setText("")
        button9.setText("")

    }

    private fun resetCounter() {
        clickCounter = 0
    }



}