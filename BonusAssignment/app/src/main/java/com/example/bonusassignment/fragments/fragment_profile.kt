package com.example.bonusassignment.fragments

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.bonusassignment.R

class fragment_profile:Fragment(R.layout.layout_profile) {

    private lateinit var nameTV:TextView
    private lateinit var lastNameTV:TextView
    private lateinit var ageTV:TextView
    private lateinit var imageView: ImageView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        nameTV = view.findViewById(R.id.nameTextView)
        lastNameTV = view.findViewById(R.id.lastNameTextView)
        imageView = view.findViewById(R.id.imageView)
        ageTV = view.findViewById(R.id.ageTextView)

        val sharedPreferences = this.activity!!.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)

        val savedName = sharedPreferences.getString("NAME", "")
        val savedLastName = sharedPreferences.getString("LASTNAME", "")
        val savedUrl = sharedPreferences.getString("URL", "https://cdn.fastly.picmonkey.com/content4/previews/question_marks/question_marks_12_550.png")
        val savedAge = sharedPreferences.getString("AGE", "0")

        nameTV.text = savedName
        lastNameTV.text = savedLastName
        ageTV.text = savedAge

        Glide.with(view)
            .load(savedUrl)
            .placeholder(R.drawable.question_marks_12_550)
            .centerCrop()
            .into(imageView)




    }

}