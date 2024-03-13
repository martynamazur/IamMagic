package com.example.immagic.nawigation.favourite.cardset



import android.graphics.drawable.Icon
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class FavouriteCardSetAdapter(private var favouriteCardSetList: List<FavouriteCardSetModel>) : RecyclerView.Adapter<FavouriteCardSetAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.unlocked_cardset, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return favouriteCardSetList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = favouriteCardSetList[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener {

        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val subcategorySelectionName: TextView = itemView.findViewById(R.id.subcategorySelectionName)
        private val subcategoryIcon: ImageView = itemView.findViewById(R.id.subcategoryIcon)
        private val subcategoryItemCard: CardView = itemView.findViewById(R.id.subcategoryItem)

        fun bind(favouriteCardSet: FavouriteCardSetModel) {
            subcategorySelectionName.text = favouriteCardSet.subcategoryName
            val iconPath = favouriteCardSet.iconPath
            val icon = Icon.createWithFilePath(iconPath)
            subcategoryIcon.setImageIcon(icon)
        }
    }

    fun updateCardSetList(newFavouriteCardSetList: List<FavouriteCardSetModel>?) {
        if (newFavouriteCardSetList != null) {
            favouriteCardSetList = newFavouriteCardSetList
            notifyDataSetChanged()
        }
    }

}
