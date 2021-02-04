package com.example.finalexam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeActivity : AppCompatActivity() {

    private lateinit var newPass:EditText
    private lateinit var confirmNewPass:EditText
    private lateinit var changeButton: Button
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_change)

        mAuth = FirebaseAuth.getInstance()

        newPass = findViewById(R.id.newPassEditText)
        confirmNewPass = findViewById(R.id.confirmNewPassEditText)
        changeButton = findViewById(R.id.changePassButton)


        changeButton.setOnClickListener {
            val pass = newPass.text.toString()
            val confirm = confirmNewPass.text.toString()

            if (pass.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(this, "One or more fields are empty", Toast.LENGTH_SHORT).show()
            } else if (pass == confirm) {
                mAuth.currentUser?.updatePassword(pass)?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, LogInActivity::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Error !!!", Toast.LENGTH_SHORT).show()
                    }
                }
            }else if(pass != confirm) {
                Toast.makeText(this, "Fields don't match, check again!", Toast.LENGTH_SHORT).show()
            }
        }

    }
}