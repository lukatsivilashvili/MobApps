package com.example.finalexam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.finalexam.LogInActivity
import com.example.finalexam.PasswordChangeActivity
import com.example.finalexam.R
import com.example.finalexam.RecyclerView.NotesInfo
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class EditNotesFragment: Fragment(R.layout.fragment_edit_notes) {

    private lateinit var headingEditText: EditText
    private lateinit var contentEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var logOutFloatingButton: FloatingActionButton
    private lateinit var changePassFloatingButton:FloatingActionButton
    private lateinit var navController: NavController

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db:DatabaseReference



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("UserInfo")

        sendButton = view.findViewById(R.id.sendButton)
        headingEditText = view.findViewById(R.id.headingEditText)
        contentEditText = view.findViewById(R.id.contentEditText)
        navController = Navigation.findNavController(view)
        logOutFloatingButton = view.findViewById(R.id.logOutFloatingActionButton)
        changePassFloatingButton = view.findViewById(R.id.changePassFloatingButton)

        sendButton.setOnClickListener {

            val heading = headingEditText.text.toString()
            val content = contentEditText.text.toString()

            val notesInfo = NotesInfo(heading, content)

            if (mAuth.currentUser?.uid != null) {

                db.child(mAuth.currentUser?.uid!!).setValue(notesInfo)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(view.context, "Success", Toast.LENGTH_SHORT).show()
                            headingEditText.text = null
                            contentEditText.text = null
                        } else {
                            Toast.makeText(view.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }

            }

        }

        logOutFloatingButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(requireContext(), LogInActivity::class.java))
            activity?.finish()

        }

        changePassFloatingButton.setOnClickListener {

            startActivity(Intent(view.context, PasswordChangeActivity::class.java))
            activity?.finish()

        }


    }

}