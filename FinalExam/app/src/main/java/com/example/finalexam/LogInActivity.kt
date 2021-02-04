package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class LogInActivity : AppCompatActivity() {

    private lateinit var logMail:EditText
    private lateinit var logPassword:EditText
    private lateinit var logLogInButton: Button
    private lateinit var logRegisterButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        mAuth = FirebaseAuth.getInstance()

        logMail = findViewById(R.id.logEmailEditText)
        logPassword = findViewById(R.id.logPasswordEditText)
        logLogInButton = findViewById(R.id.logLogInButton)
        logRegisterButton = findViewById(R.id.logRegisterButton)

        logRegisterButton.setOnClickListener {
            val intent = Intent(this, SignUpScreen::class.java)
            startActivity(intent)
            finish()
        }

        logLogInButton.setOnClickListener {
            val email = logMail.text.toString()
            val password = logPassword.text.toString()

            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_SHORT).show()
            }else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }else {
                        Toast.makeText(this, "Error !!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}