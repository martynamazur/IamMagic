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

class BoostAdapter(context: Context, private val boostersItemModelList: List<BoostersItemModel>) :
    RecyclerView.Adapter<BoostAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val boostImageView: ImageView = itemView.findViewById(R.id.boostIcon)
        val boostHeadline: TextView = itemView.findViewById(R.id.boostHeadline)
        val boostDescription: TextView = itemView.findViewById(R.id.boostDescription)
        val boostBuyBtn: Button = itemView.findViewById(R.id.boostBuyBtn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.boost_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val boostItem = boostersItemModelList[position]

        holder.boostImageView.setImageResource(boostItem.boostIcon)
        holder.boostHeadline.text = boostItem.boostName
        holder.boostDescription.text = boostItem.boostInformation
        holder.boostBuyBtn.text = boostItem.boostPrice
    }

    override fun getItemCount(): Int {
        return boostersItemModelList.size
    }
}
