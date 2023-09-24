package com.example.immagic.settings

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class SettingsAdapter(
    private val context: Context,
    private val dataList: ArrayList<SettingsModel>
) : RecyclerView.Adapter<SettingsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.settings_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.textView.text = item.text

        val resId = context.resources.getIdentifier(item.iconName, "drawable", context.packageName)
        holder.imageView.setImageResource(resId)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView =  itemView.findViewById(R.id.settingName)
        val imageView: ImageView = itemView.findViewById(R.id.settingIcon)
    }
}
