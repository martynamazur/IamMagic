package com.example.immagic.nawigation.favourite

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.favourite.cardset.FavouriteCardSetModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FavouriteImpl(private val context: Context) : FavouriteRepository {
    override suspend fun getAllFavouriteCards(): List<FavouriteCardsModel> {
        return try{
            withContext(Dispatchers.IO){
                val db = AppDatabase.getInstance(context)
                val userActionsQuoteDao = db.userActionsQuote()
                userActionsQuoteDao.getAllFavouriteQuotes()
            }
        }catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }

    }

    override suspend fun getTotalNumberOfFavouriteCardSet(): Int {
        return  try {
            withContext(Dispatchers.IO){
                val db = AppDatabase.getInstance(context)
                val favouriteCardSet = db.favouriteCardSet()
                favouriteCardSet.getTotalNumberOfFavCardSet()
            }
        }catch (e: Exception){
            e.printStackTrace()
            0
        }
    }

    override suspend fun getTotalNumberOfFavouriteCards(): Int {
        return getAllFavouriteCards().size

    }

    override suspend fun deleteQuoteFromList(quoteId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllFavouriteCardSet(): List<FavouriteCardSetModel> {
        return try{
            val db = AppDatabase.getInstance(context)
            val favDao = db.favouriteCardSet()
            favDao.getAllCardSet()
        }catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }
    }
}