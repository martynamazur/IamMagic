package com.example.immagic.nawigation.myprofile.myaddedcards.notempty

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.createquote.CreateNewQuoteModel

class MyCardsListAdapter(private val quoteList: ArrayList<CreateNewQuoteModel>):
RecyclerView.Adapter<MyCardsListAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.quoteContentMyCards)
    }

    // Tworzenie nowego widoku ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_mycards_list, parent, false)

        return MyViewHolder(itemView)
    }

    // Uzupełnianie danych w widoku ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.textView.text = quoteList[position].quoteContent
    }

    // Zwracanie liczby elementów w liście
    override fun getItemCount(): Int {
        return quoteList.size
    }
}