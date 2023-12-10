package com.example.immagic.nawigation.categories.shop

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.categories.shop.treasurechest.*
import kotlinx.coroutines.*

class MagicChestAdapter(
    private val context: Context,
    private val magicChestItemList: List<MagicChestItemModel>,
    private val viewModel: ChestDialogViewModel,
    private val chestDialogRepository: ChestDialogRepository
) :
    RecyclerView.Adapter<MagicChestAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val chestImageView: ImageView = itemView.findViewById(R.id.backgroundIcon)
        val chestNameTextView: TextView = itemView.findViewById(R.id.chestNameText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.magic_chest_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val magicChestItem = magicChestItemList[position]

        holder.chestImageView.setImageResource(magicChestItem.chestIcon)
        holder.chestNameTextView.text = magicChestItem.chestNameText


        holder.chestImageView.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val chestDialog = ChestDialog(context,position, viewModel, chestDialogRepository)
                chestDialog.createDialog()
            }

        }
    }









    override fun getItemCount(): Int {
        return magicChestItemList.size
    }
}
