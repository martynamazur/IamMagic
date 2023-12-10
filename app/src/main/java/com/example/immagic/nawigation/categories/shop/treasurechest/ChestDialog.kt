package com.example.immagic.nawigation.categories.shop.treasurechest

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.categories.shop.treasurechest.TreasureChestModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.w3c.dom.Text

class ChestDialog(
    private val context: Context,
    private val chestId: Int,
    private val viewModel: ChestDialogViewModel,
    private val chestRepository: ChestDialogRepository) {

    private lateinit var chestDialogViewModel: ChestDialogViewModel

    private lateinit var openChestBtn: Button
    private lateinit var chestPriceBtn: Button
    private lateinit var closePopUpDialogChest: ImageButton
    private lateinit var chestTypeName: TextView
    private lateinit var chestIcon: ImageView

    private lateinit var rewardsRc: RecyclerView
    private lateinit var chestModel: TreasureChestModel
    private lateinit var chestQuantity: TextView


    suspend fun createDialog() {
        val builder = AlertDialog.Builder(context)

        val inflater = LayoutInflater.from(context)
        val dialogView = inflater.inflate(R.layout.custom_dialog_chest_layout, null)
        builder.setView(dialogView)

        openChestBtn = dialogView.findViewById(R.id.openChestBtn)
        chestPriceBtn = dialogView.findViewById(R.id.buyChestBtn)
        closePopUpDialogChest = dialogView.findViewById(R.id.closePopUpDialogChest)
        chestTypeName = dialogView.findViewById(R.id.chestTypeName)
        chestIcon = dialogView.findViewById(R.id.chestIcon)
        chestQuantity = dialogView.findViewById(R.id.chestQuantity)


        chestModel = chestRepository.getChestInformation(chestId)
        val ownedChests = chestRepository.getInfAboutAmountOfOwnedChest(chestModel.chestType) ?: 0


        setUpUiView(ownedChests)

        val dialog = builder.create()

        closePopUpDialogChest.setOnClickListener {
            dialog.dismiss()
        }

        openChestBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                chestRepository.updateChestQuantity(chestModel.chestType,-1)
            }
        }

        chestPriceBtn.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                chestRepository.updateChestQuantity(chestModel.chestType,1)
            }
        }

        dialog.show()
    }



    private fun setUpUiView(ownedChests: Int) {


        chestPriceBtn.text = chestModel.price.toString()
        chestTypeName.text = chestModel.chestType
        chestIcon.setImageResource(chestModel.resourceIconId)
        chestQuantity.text = ownedChests.toString()
    }}