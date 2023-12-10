package com.example.immagic.nawigation.categories.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class FreezStreakAdapter(private val context: Context, private val freezStoneItemModelList: List<FreezStreakItemModel>) :
    RecyclerView.Adapter<FreezStreakAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val freezStonetImageView: ImageView = itemView.findViewById(R.id.boostIcon)
        val freezStoneHeadline: TextView = itemView.findViewById(R.id.boostHeadline)
        val freezStoneBuyBtn: Button = itemView.findViewById(R.id.boostBuyBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.boost_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bootItem = freezStoneItemModelList[position]

        holder.freezStonetImageView.setImageResource(bootItem.freezStoneIcon)
        holder.freezStoneHeadline.text = bootItem.freezStoneName
        holder.freezStoneBuyBtn.text = bootItem.freezStonePrice
    }

    override fun getItemCount(): Int {
        return freezStoneItemModelList.size
    }
}
