package com.example.intent

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var noteEditText: EditText
    private lateinit var addButton: Button
    private lateinit var noteTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        noteEditText = findViewById(R.id.editTextNote)
        addButton = findViewById(R.id.addButton)
        noteTextView = findViewById(R.id.textView)

        val sharedPref = getSharedPreferences("MyNoteSharedPref", Context.MODE_PRIVATE)
        val sharedText:String? = sharedPref.getString("NOTE", "")

        noteTextView.text = sharedText

        addButton.setOnClickListener {

            val input = noteEditText.text.toString()
            if (!TextUtils.isEmpty(input)) {

                val text = noteTextView.text.toString()

                val resultText = input + "\n" + text

                noteTextView.text = resultText
                noteEditText.setText("")

                sharedPref.edit().putString("NOTE", resultText).apply()

        }


        }
    }
}