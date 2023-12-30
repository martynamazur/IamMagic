package com.example.immagic.database.interfaceDao

import androidx.room.Dao

@Dao
interface CardSetPriceDao{

    suspend fun getCardSetPrice(cardSetId: Int): Int
}