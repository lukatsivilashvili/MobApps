package com.example.finalexam.fragments

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexam.AllNotesActivity
import com.example.finalexam.R
import com.example.finalexam.RecyclerView.NotesAdapter
import com.example.finalexam.RecyclerView.NotesInfo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class ViewNotesFragment : Fragment(R.layout.fragment_view_notes) {

    private lateinit var headTextView:TextView
    private lateinit var contextTextView:TextView
    private lateinit var allNotesButton: Button

    private lateinit var navController: NavController

    private lateinit var mAuth: FirebaseAuth
    private lateinit var db: DatabaseReference

    companion object {
        var noteList = ArrayList<NotesInfo>()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        mAuth = FirebaseAuth.getInstance()
        db = FirebaseDatabase.getInstance().getReference("UserInfo")


        val reference : DatabaseReference = FirebaseDatabase.getInstance().reference.child("UserInfo").child(mAuth.currentUser?.uid!!).child("Notes")
        headTextView = view.findViewById(R.id.notes_heading1)
        contextTextView = view.findViewById(R.id.notes_content1)
        allNotesButton = view.findViewById(R.id.allNotesButton)
        navController = Navigation.findNavController(view)


        allNotesButton.setOnClickListener {
            startActivity(Intent(activity, AllNotesActivity::class.java))
            fun updateList(view: View){
                reference.setValue(noteList).addOnCompleteListener { task ->
                    if(task.isSuccessful){
                        Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            updateList(view)

        }


        if (mAuth.currentUser?.uid != null) {

            db.child(mAuth.currentUser?.uid!!).addValueEventListener(object : ValueEventListener {
                override fun onCancelled(error: DatabaseError) {
                    Toast.makeText(activity, "Error!", Toast.LENGTH_SHORT).show()
                }

                override fun onDataChange(snapshot: DataSnapshot) {
                    val p = snapshot.getValue(NotesInfo::class.java)

                    if (p != null && activity != null) {
                        headTextView.text = p.heading
                        contextTextView.text = p.content


                        var isInList: Boolean = false
                        for (i in noteList){
                            if (i.heading == p.heading && i.content == p.content){
                                isInList = true
                            }
                        }
                        if (!isInList && p.heading != null && p.content != null){
                            noteList.add(NotesInfo(p.heading,p.content))
                        }

                    }
                }
            })
        }

    }

}