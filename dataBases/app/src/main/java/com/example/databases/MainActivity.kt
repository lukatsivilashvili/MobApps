package com.example.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var signMail: EditText
    private lateinit var signPassword: EditText
    private lateinit var signConfirm: EditText
    private lateinit var signButton: Button
    private lateinit var logButton: Button
    private lateinit var recButton: Button

    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance()


        signMail = findViewById(R.id.signMailEditText)
        signPassword = findViewById(R.id.signMailPasswordEditText)
        signConfirm = findViewById(R.id.signMailConfirmEditText)
        signButton = findViewById(R.id.signButton)
        logButton = findViewById(R.id.logButton)
        recButton = findViewById(R.id.recButton)


        signButton.setOnClickListener{

            val mail = signMail.text.toString()
            val password = signPassword.text.toString()
            val confirm = signConfirm.text.toString()

            if (mail.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "ველი ცარიელია!", Toast.LENGTH_LONG).show()
            } else if(password != confirm) {
                Toast.makeText(this, "პაროლები არ ემთხვევა!", Toast.LENGTH_LONG).show()
            } else {
                mAuth.createUserWithEmailAndPassword(mail, password).addOnCompleteListener{task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, loginActivity::class.java))
                        finish()
                    }else {
                        Toast.makeText(this, "შეცდომა!", Toast.LENGTH_LONG).show()
                    }
                }

            }

        }

        logButton.setOnClickListener {
            startActivity(Intent(this,loginActivity::class.java))
            finish()
        }
    }
}