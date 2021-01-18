package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class productAdapter(private var products:List<Product>):
    RecyclerView.Adapter<productAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {

        val imageView:ImageView = itemView.findViewById(R.id.imageView)
        val textView:TextView = itemView.findViewById(R.id.textView)
        val textView2:TextView = itemView.findViewById(R.id.textView2)
        val imageView2:ImageView = itemView.findViewById(R.id.imageView3)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val p = products[position]

        holder.imageView.setImageResource(p.image)
        holder.textView.text = p.title
        holder.textView2.text = p.description

        if (!p.isImportant) {
            holder.imageView2.visibility = View.GONE
    }


    }

    override fun getItemCount(): Int  = products.size

}