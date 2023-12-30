package com.example.immagic.nawigation.categories.shop.boosts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.categories.shop.InsufficientFundsDialog
import com.example.immagic.nawigation.categories.shop.ItemType
import com.example.immagic.nawigation.categories.shop.PaymentManager
import kotlinx.coroutines.*


class BoostAdapter(
    private val context: Context,
   private val boostersItemModelList: List<BoostersItemModel>,
   private val paymentManager: PaymentManager
   ) : RecyclerView.Adapter<BoostAdapter.ViewHolder>() {

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

        holder.boostBuyBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val isSufficientFunds = withContext(Dispatchers.IO) {
                    paymentManager.buyItem(
                        holder.boostBuyBtn.text.toString().toInt(),
                        0,
                        ItemType.COINS
                    )
                }

                if (isSufficientFunds == false){
                    val insufficientFundsDialog = InsufficientFundsDialog(context)
                    insufficientFundsDialog.show()

                }

            }
        }
        }

    override fun getItemCount(): Int {
        return boostersItemModelList.size
    }

}


