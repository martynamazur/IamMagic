package com.example.immagic.nawigation.categories.category.categoryselection

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.Subscription.SubscriptionOverView


class SubcategoryAdapter(
    private val statisticModelList: ArrayList<CategorySelectionModel>,
    private val subcategoryPriceList: ArrayList<SubcategoryPrice>,
    private var walletBalance: Int,
    private val walletUpdateListener: WalletUpdateListener,
    private val categoryUpdateListener: UpdateCategoryAvailabilityListener

) : RecyclerView.Adapter<SubcategoryAdapter.ViewHolder>() {

    companion object {
        const val UNLOCKED = 0
        const val LEVEL_BASED_UNLOCK = 1
        const val BUY = 2
        const val PREMIUM_SUBSCRIPTION = 3
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val subcategorySelectionName: TextView = itemView.findViewById(R.id.subcategorySelectionName)
        val buySubcategoryBtn: Button = itemView.findViewById(R.id. buySubcategoryBtn)
        val levelUnlock : TextView = itemView.findViewById(R.id.levelUnlock)
        val lockedType1 : LinearLayout = itemView.findViewById(R.id.lockedType1)
        val subcategoryItem: CardView = itemView.findViewById(R.id.subcategoryItem)
        val lockIcon: ImageView = itemView.findViewById(R.id.lockIcon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.subcategory_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = statisticModelList[position]
        holder.subcategorySelectionName.text = item.subcategoryName

        holder.subcategoryItem.setOnClickListener {
            when(item.lockedStatus){
                UNLOCKED ->
                {
                    val intent = Intent(holder.subcategoryItem.context, CategoryOverView::class.java)
                    intent.putExtra("cardSetId", item.subcategoryId)
                    holder.subcategoryItem.context.startActivity(intent)
                }

                LEVEL_BASED_UNLOCK -> { showDialogWarning(holder.subcategoryItem.context) }

                BUY ->{

                    holder.buySubcategoryBtn.setOnClickListener {

                        val subcategoryPrice = subcategoryPriceList.find { it.subcategoryId == item.subcategoryId }
                        if (walletBalance < subcategoryPrice!!.price){
                            showDialogWarningBalance(holder.subcategoryItem.context)
                        }else{
                            walletUpdateListener.updateWalletBalance(subcategoryPrice.price * (-1))
                            categoryUpdateListener.updateCategoryAvailability(0, item.subcategoryId)

                        }
                    }

                }
                PREMIUM_SUBSCRIPTION ->
                    {
                    val intent = Intent(holder.subcategoryItem.context, SubscriptionOverView::class.java)
                    holder.subcategoryItem.context.startActivity(intent)
                }
            }
        }


        when(item.lockedStatus){
            UNLOCKED ->
            {
                holder.lockedType1.visibility = View.GONE
                holder.buySubcategoryBtn.visibility = View.GONE
                holder.lockIcon.visibility = View.GONE
            }
            LEVEL_BASED_UNLOCK ->
            {
                holder.levelUnlock.text = "Lv "
                holder.buySubcategoryBtn.visibility = View.GONE
            }
            BUY ->
            {
                holder.levelUnlock.visibility = View.GONE
                holder.lockIcon.visibility = View.GONE

                val subcategoryPrice = subcategoryPriceList.find { it.subcategoryId == item.subcategoryId }
                holder.buySubcategoryBtn.text = subcategoryPrice.toString()

            }
            PREMIUM_SUBSCRIPTION ->
            {
                holder.levelUnlock.text = "Premium "
                holder.buySubcategoryBtn.visibility = View.GONE

            }

        }


    }


    override fun getItemCount(): Int {
        return statisticModelList.size
    }

    private fun showDialogWarning( context: Context){
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.apply {
            setTitle("Ups")
            setMessage("You have not reached a sufficient level to unlock this category.")
            setPositiveButton("Ok"){ dialog, _ -> dialog.dismiss()}

        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }
    private fun showDialogWarningBalance( context: Context){
        val alertDialogBuilder = AlertDialog.Builder(context)
        alertDialogBuilder.apply {
            setTitle("Ups")
            setMessage("You don't have enough funds in your wallet")
            setPositiveButton("Ok"){ dialog, _ -> dialog.dismiss()}

        }
        val alertDialog: AlertDialog = alertDialogBuilder.create()
        alertDialog.show()
    }

}
