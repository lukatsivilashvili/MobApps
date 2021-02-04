 package com.example.finalexam.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.finalexam.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

class NotesAdapter(private var notes:List<NotesInfo>):RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {

    class NotesViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){

        val heading:TextView = itemView.findViewById(R.id.notes_heading)
        val content:TextView = itemView.findViewById(R.id.notes_content)

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notes_recycler, parent, false)
        return NotesViewHolder(view)

    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val pos = notes[position]

        holder.heading.text = pos.heading
        holder.content.text = pos.content
    }

    override fun getItemCount(): Int = notes.size

}