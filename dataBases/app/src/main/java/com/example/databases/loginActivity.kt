package com.example.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {

    private lateinit var inputEmail: EditText
    private lateinit var inputPassword: EditText
    private lateinit var loginButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if(mAuth.currentUser != null) {
            gotoPerson()
        }

        setContentView(R.layout.activity_login)

        inputEmail = findViewById(R.id.emailEditText)
        inputPassword = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {

            val email = inputEmail.text.toString()
            val password = inputPassword.text.toString()
            
            if(email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ველი ცარიელია !", Toast.LENGTH_SHORT).show()
            }else {
                mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
                    task ->
                    if (task.isSuccessful) {
                        gotoPerson()
                    }else{
                        Toast.makeText(this, "შეცდომა!", Toast.LENGTH_SHORT).show()
                    }
                }
            }

        }

    }

    private fun gotoPerson() {
        startActivity(Intent(this, personActivity::class.java))
        finish()
    }
}