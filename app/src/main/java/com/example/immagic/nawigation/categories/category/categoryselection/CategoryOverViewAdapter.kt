package com.example.immagic.nawigation.categories.category.categoryselection

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class CategoryOverViewAdapter(private val quoteContent: List<String>):
RecyclerView.Adapter<CategoryOverViewAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val quoteContentField: TextView = itemView.findViewById(R.id.quoteContentField)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quote_content_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return quoteContent.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.quoteContentField.text = quoteContent[position]

    }


}