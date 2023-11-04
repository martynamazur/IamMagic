package com.example.immagic.nawigation.favourite.singlecards.manage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R


class LikedQuotesAdapter(private val likedQuoteList: ArrayList<LikedQuotesModel>) : RecyclerView.Adapter<LikedQuotesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.quoteTextField)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.liked_quote_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = likedQuoteList[position]
        holder.textView.text = item.quoteContent
    }

    override fun getItemCount(): Int {
        return likedQuoteList.size
    }
}
