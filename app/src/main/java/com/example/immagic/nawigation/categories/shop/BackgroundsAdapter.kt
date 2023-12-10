package com.example.immagic.nawigation.categories.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import android.widget.ImageView as ImageView1

class BackgroundsAdapter(context: Context, private val backgroundsItemList: List<BackgroundsItemModel>) :
    RecyclerView.Adapter<BackgroundsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundsImageView: ImageView1 = itemView.findViewById(R.id.backgroundsIcon)
        val backgroundsCoinsHeadline: TextView = itemView.findViewById(R.id.backgroundsCoinsHeadline)
        val backgroundsPuzzleHeadline: TextView = itemView.findViewById(R.id.backgroundsPuzzleHeadline)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.background_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val backgroundsItem = backgroundsItemList[position]

        holder.backgroundsImageView.setImageResource(backgroundsItem.background)
        holder.backgroundsCoinsHeadline.text = backgroundsItem.backgroundPrice
        holder.backgroundsPuzzleHeadline.text = backgroundsItem.backgroundAmountOfPuzzle
    }

    override fun getItemCount(): Int {
        return backgroundsItemList.size
    }
}
