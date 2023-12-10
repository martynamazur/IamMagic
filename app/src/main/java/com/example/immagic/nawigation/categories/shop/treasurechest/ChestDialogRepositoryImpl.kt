package com.example.immagic.nawigation.categories.shop.treasurechest

import android.content.Context
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.interfaceDao.TreasureChestDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ChestDialogRepositoryImpl(private val context: Context, private val viewModel: ChestDialogViewModel): ChestDialogRepository {

    override suspend fun getChestInformation(chestId: Int): TreasureChestModel {
        return try {
            withContext(Dispatchers.IO) {
                val applicationContext = context
                val db = AppDatabase.getInstance(applicationContext)
                val treasureChestDao = db.treasureChest()
                treasureChestDao.getInformationAboutChest(chestId)
                    ?: TreasureChestModel(0, "", 0, R.drawable.basicchest)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    override suspend fun getInfAboutAmountOfOwnedChest(chestType: String): Int? {
        return try {
            withContext(Dispatchers.IO) {
                val db = AppDatabase.getInstance(context)
                val userEquimpmentDao = db.userEquimpment()
                userEquimpmentDao.getQuantityOf(chestType)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

    override suspend fun updateChestQuantity(chestType: String, newValue: Int) {
        withContext(Dispatchers.IO) {
            val db = AppDatabase.getInstance(context)
            val userEquimpmentDao = db.userEquimpment()
            userEquimpmentDao.updateQuantity(chestType, newValue)
            viewModel.updateChestQuantity(newValue)
        }
    }

}