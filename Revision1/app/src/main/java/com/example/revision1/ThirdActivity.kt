package com.example.revision1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ThirdActivity : AppCompatActivity() {

    private lateinit var nameTextView: TextView
    private lateinit var ageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)


        nameTextView = findViewById(R.id.textView)
        ageTextView = findViewById(R.id.textView2)

        val extras:Bundle?   = intent.extras

        if (extras != null) {

            nameTextView.text = extras.getString("NAME", "")
            ageTextView.text = extras.getInt("AGE", 0).toString()

        }
    }
}