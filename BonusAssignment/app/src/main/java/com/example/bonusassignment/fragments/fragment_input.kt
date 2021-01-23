package com.example.bonusassignment.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bonusassignment.R

class fragment_input: Fragment(R.layout.layout_input) {

    private lateinit var nameEditText: EditText
    private lateinit var lastNameEditText: EditText
    private lateinit var urlEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var button: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameEditText = view.findViewById(R.id.nameEditText)
        lastNameEditText = view.findViewById(R.id.lastNameEditText)
        urlEditText = view.findViewById(R.id.urlEditText)
        ageEditText = view.findViewById(R.id.ageEditText)
        button = view.findViewById(R.id.sendButton)


        button.setOnClickListener {
            val insertedName = nameEditText.text.toString()
            val insertedLastName = lastNameEditText.text.toString()
            val insertedUrl = urlEditText.text.toString()
            val insertedAge = ageEditText.text.toString()

            val sharedPreferences = this.activity!!.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.apply {
                putString("NAME", insertedName)
                putString("LASTNAME", insertedLastName)
                putString("URL", insertedUrl)
                putString("AGE", insertedAge)
            }.apply()

            Toast.makeText(view.context, "saved", Toast.LENGTH_SHORT).show()
        }


    }


}