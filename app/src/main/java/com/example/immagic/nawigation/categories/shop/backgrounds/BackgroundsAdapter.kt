package com.example.immagic.nawigation.categories.shop.backgrounds

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.categories.shop.InsufficientFundsDialog
import com.example.immagic.nawigation.categories.shop.ItemType
import com.example.immagic.nawigation.categories.shop.PaymentManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import android.widget.ImageView as ImageView1

class BackgroundsAdapter(
    private val context: Context,
    private val backgroundsItemList: List<BackgroundsItemModel>,
    private val paymentManager: PaymentManager

    ) :
    RecyclerView.Adapter<BackgroundsAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val backgroundsImageView: ImageView1 = itemView.findViewById(R.id.backgroundsIcon)
        val backgroundsCoinsHeadline: TextView = itemView.findViewById(R.id.backgroundsCoinsHeadline)
        val backgroundsPuzzleHeadline: TextView = itemView.findViewById(R.id.backgroundsPuzzleHeadline)
        val backgroundBuy: LinearLayout = itemView.findViewById(R.id.backgroundBuy)
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
        //caly layout jako przycisk

        holder.backgroundBuy.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val isSufficientFunds = withContext(Dispatchers.IO) {
                    paymentManager.buyItem(
                        backgroundsItem.backgroundPrice.toInt(),
                        backgroundsItem.backgroundAmountOfPuzzle.toInt(),
                        ItemType.COINS_AND_PUZZLE
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
        return backgroundsItemList.size
    }
}
