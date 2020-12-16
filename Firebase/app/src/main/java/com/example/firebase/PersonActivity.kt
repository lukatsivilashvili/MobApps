package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import kotlin.math.log

class PersonActivity : AppCompatActivity() {

    private lateinit var personInfo: TextView
    private lateinit var changeButton: Button
    private lateinit var logOutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        mAuth = FirebaseAuth.getInstance()

        personInfo = findViewById(R.id.personInfoTextView)
        changeButton = findViewById(R.id.goToPasswordChangeButton)
        logOutButton = findViewById(R.id.logOutButton)

        personInfo.text = mAuth.currentUser?.uid

        logOutButton.setOnClickListener {

            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()

        }

        changeButton.setOnClickListener {
            startActivity(Intent(this, ChangeActivity::class.java))
        }

    }
}