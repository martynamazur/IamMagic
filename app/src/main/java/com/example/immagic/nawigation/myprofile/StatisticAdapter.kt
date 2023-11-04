package com.example.immagic.nawigation.myprofile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R


class StatisticAdapter(private val statisticModelList: ArrayList<ProfileStatisticModel>) : RecyclerView.Adapter<StatisticAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val statisticTypeName: TextView = itemView.findViewById(R.id.statisticTypeName)
        val number: TextView = itemView.findViewById(R.id.number)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.statistic_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = statisticModelList[position]

        holder.number.text = item.number
        holder.statisticTypeName.text = item.statisticTypeName

    }

    override fun getItemCount(): Int {
        return statisticModelList.size
    }
}
