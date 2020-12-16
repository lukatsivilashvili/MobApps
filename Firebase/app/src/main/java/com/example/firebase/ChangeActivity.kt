package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

class ChangeActivity : AppCompatActivity() {

    private lateinit var inputCurrentPass: EditText
    private lateinit var inputNewPass: EditText
    private lateinit var resetButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change)

        mAuth = FirebaseAuth.getInstance()

        inputCurrentPass = findViewById(R.id.currPasswordEditText)
        inputNewPass = findViewById(R.id.newPasswordEditText)
        resetButton = findViewById(R.id.resetButton)


        resetButton.setOnClickListener {

            val user = mAuth.currentUser
            val current = inputCurrentPass.text.toString()
            val new = inputNewPass.text.toString()

            if (current.isEmpty() || new.isEmpty() ) {
                Toast.makeText(this, "Fields are missing!", Toast.LENGTH_SHORT).show()
            } else {

                if (user != null && user.email != null) {

                    val credential = EmailAuthProvider.getCredential(user.email!!, current)

                    user.reauthenticate(credential).addOnCompleteListener {

                            if (it.isSuccessful) {
                                Toast.makeText(this, "Re-Auth Success", Toast.LENGTH_SHORT).show()
                                mAuth.currentUser?.updatePassword(new)?.addOnCompleteListener{task ->
                                    if (task.isSuccessful) {
                                        startActivity(Intent(this, PersonActivity::class.java))
                                        finish()
                                    } else {
                                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                                    }
                                }

                            } else {
                                Toast.makeText(this, "Re-Auth Failed", Toast.LENGTH_SHORT).show()
                            }

                        }
                }

            }

        }

    }
}