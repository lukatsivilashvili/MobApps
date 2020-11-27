package com.example.revision1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {

    private lateinit var ageEditText: EditText
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        ageEditText = findViewById(R.id.editTextAge)
        finishButton = findViewById(R.id.finishButton)

        var name = ""
        val extras = intent.extras
        if (extras != null) {
            name = extras.getString("PERSON_NAME", "")
        }

        finishButton.setOnClickListener {

            val age:Int = ageEditText.text.toString().toInt()

            val intent = Intent(this, ThirdActivity::class.java)
            intent.putExtra("NAME", name)
            intent.putExtra("AGE", age)

            startActivity(intent)

        }
    }
}