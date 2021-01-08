package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class userAdapter(context:Context, users: ArrayList<User>): ArrayAdapter<User>(context, 0, users) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val user = getItem(position)

        val cv = LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)

        val fnameTextView:TextView = cv.findViewById(R.id.userFirstName)
        val lnameTextView = cv.findViewById(R.id.userLastName) as TextView
        val profilePic = cv.findViewById(R.id.profilePic) as ImageView

        fnameTextView.text = user?.firstName
        lnameTextView.text = user?.lastName
        Glide.with(context)
            .load(user?.url)
            .placeholder(R.drawable.ic_launcher_background)
            .centerCrop()
            .into(profilePic)

        return cv
    }

}