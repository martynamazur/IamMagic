package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface ShopDao {

    @Query("SELECT * FROM SHOP")
    suspend fun getAllItemFromShop()//w przypadku wejscia bezposrednio do Sklepu

    @Query("SELECT price FROM Shop WHERE card_set_id =: cardSetId")
    suspend fun getCardSetById(cardSetId: Int)



}