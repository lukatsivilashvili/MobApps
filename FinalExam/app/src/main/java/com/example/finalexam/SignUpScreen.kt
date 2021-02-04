package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.finalexam.fragments.EditNotesFragment
import com.google.firebase.auth.FirebaseAuth

class SignUpScreen : AppCompatActivity() {

    private lateinit var signMail:EditText
    private lateinit var signPassword:EditText
    private lateinit var signRegisterButton: Button
    private lateinit var signLogInButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        setContentView(R.layout.activity_sign_up)


        signMail = findViewById(R.id.logEmailEditText)
        signPassword = findViewById(R.id.logPasswordEditText)
        signRegisterButton = findViewById(R.id.logLogInButton)
        signLogInButton = findViewById(R.id.signLogInButton)

        signLogInButton.setOnClickListener {
            val intent = Intent(this, LogInActivity::class.java)
            startActivity(intent)
            finish()
        }

        signRegisterButton.setOnClickListener {

            val mail = signMail.text.toString()
            val password = signPassword.text.toString()

            if(mail.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_SHORT).show()
            }else {
                mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener { task ->
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