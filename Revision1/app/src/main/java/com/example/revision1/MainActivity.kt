package com.example.revision1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editTextName)
        nextButton = findViewById(R.id.nextButton)

        nextButton.setOnClickListener {

            val name: String = nameEditText.text.toString()

            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("PERSON_NAME", name)
            startActivity(intent)

        }

    }
}