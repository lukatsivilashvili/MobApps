package com.example.databases

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class personActivity : AppCompatActivity() {

    private lateinit var nameEditText:EditText
    private lateinit var urlEditText:EditText
    private lateinit var saveButton: Button
    private lateinit var logoutButton: Button
    private lateinit var nameTextView: TextView
    private lateinit var imageView: ImageView

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("UserInfo")

        nameEditText = findViewById(R.id.nameEditText)
        urlEditText = findViewById(R.id.urlEditText)
        saveButton = findViewById(R.id.saveButton)
        logoutButton = findViewById(R.id.logoutButton)
        nameTextView = findViewById(R.id.textView6)
        imageView = findViewById(R.id.imageView)

        logoutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
        saveButton.setOnClickListener {

            val name = nameEditText.text.toString()
            val url = urlEditText.text.toString()

            val personInfo = PersonInfo(name, url)

            if (mAuth.currentUser?.uid != null){

                db.child(mAuth.currentUser?.uid!!).setValue(personInfo).addOnCompleteListener{
                    task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "წარმატება!", Toast.LENGTH_LONG).show()
                        nameEditText.text = null
                        urlEditText.text = null
                    }else {
                        Toast.makeText(this, "შეცდომა!", Toast.LENGTH_SHORT).show()
                    }
                }

            }


        }

        if(mAuth.currentUser?.uid != null) {

            db.child(mAuth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val p = snapshot.getValue(PersonInfo::class.java)

                    if (p != null) {
                        nameTextView.text = p.name

                        Glide.with(this@personActivity)
                            .load(p.url)
                            .centerCrop()
                            .placeholder(R.drawable.ic_launcher_background)
                            .into(imageView)

                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(this@personActivity, "შეცდომა!", Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}