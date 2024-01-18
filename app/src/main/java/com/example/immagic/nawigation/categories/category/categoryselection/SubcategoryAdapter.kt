package com.example.immagic.nawigation.categories.category.categoryselection

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R



class SubcategoryAdapter(
    private val statisticModelList: ArrayList<CategorySelectionModel>,
    private val subcategoryPriceList: ArrayList<SubcategoryPrice>
) : RecyclerView.Adapter<SubcategoryAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val subcategorySelectionName: TextView = itemView.findViewById(R.id.subcategorySelectionName)
        val buySubcategoryBtn: Button = itemView.findViewById(R.id. buySubcategoryBtn)
        val levelUnlock : TextView = itemView.findViewById(R.id.levelUnlock)
        val lockedType1 : LinearLayout = itemView.findViewById(R.id.lockedType1)
        val subcategoryItem: LinearLayout = itemView.findViewById(R.id.subcategoryItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subcategory_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = statisticModelList[position]
        holder.subcategorySelectionName.text = item.subcategoryName

        holder.subcategoryItem.setOnClickListener {
            if (item.lockedStatus == 0) {

                val intent = Intent(holder.subcategoryItem.context, CategoryOverView::class.java)
                intent.putExtra("cardSetId", item.subcategoryId)
                holder.subcategoryItem.context.startActivity(intent)

            }
        }


        when(item.lockedStatus){
            0 -> // unlocked
            {
                holder.lockedType1.visibility = View.GONE
                holder.buySubcategoryBtn.visibility = View.GONE
            }
            1 -> // unlock based on level
            {
                holder.levelUnlock.text = " Lv"
                holder.buySubcategoryBtn.visibility = View.GONE
            }
            2 -> //buy
            {
                holder.levelUnlock.visibility = View.GONE
            }
            3 -> // premium subscription
            {
                holder.levelUnlock.text = " Premium "
                holder.buySubcategoryBtn.visibility = View.GONE
            }

        }




    }

    override fun getItemCount(): Int {
        return statisticModelList.size
    }
}
