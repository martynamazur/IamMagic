package com.example.immagic.nawigation.favourite.singlecards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.FavouriteCardsModel

class FavouriteCardsAdapter(
    private var favouriteCards: List<FavouriteCardsModel>,
    private var unlikeQuoteListener: UnlikeQuoteListener
) : RecyclerView.Adapter<FavouriteCardsAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val favQuoteContent: TextView = itemView.findViewById(R.id.favQuoteContent)
        val removeFromFavourites: ImageButton = itemView.findViewById(R.id.removeFromFavourites)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.favourite_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return favouriteCards.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favouriteCard = favouriteCards[position]
        holder.favQuoteContent.text = favouriteCard.quoteContent

        holder.removeFromFavourites.setOnClickListener {
            // usuwam z listy
            // usuwam z tabelki useractions cala pozycje
        }

    }

    fun updateData(newFavouriteCards: List<FavouriteCardsModel>) {
        favouriteCards = newFavouriteCards
        notifyDataSetChanged()
    }

}
