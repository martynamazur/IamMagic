package com.example.immagic.nawigation.categories


import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.settings.OnSettingItemClickListener

class CategoryAdapter(
    private val itemClickListener: OnSettingItemClickListenerCategory,
    private val context: Context,
    private val dataList: ArrayList<CategoryModel>
) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.category_item, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]

        holder.categoryName.text = item.categoryName

        val resId = context.resources.getIdentifier(item.iconPath, "drawable", context.packageName)
        holder.categoryIcon.setImageResource(resId)

        holder.itemView.setOnClickListener {
            itemClickListener.onSettingItemClickedCategory(position)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryName: TextView =  itemView.findViewById(R.id.categoryName)
        val categoryIcon: ImageView = itemView.findViewById(R.id.categoryIcon)
        val categoryNext: ImageView = itemView.findViewById(R.id.imageButton2)
    }
}
