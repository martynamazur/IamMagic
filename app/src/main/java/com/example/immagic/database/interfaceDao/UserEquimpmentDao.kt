package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserEquimpmentDao  {

    //quantity of chest - Shop
    @Query("Select quantity FROM UserEquipment WHERE itemType = :itemType")
    suspend fun getQuantityOf(itemType: String): Int

    @Query("UPDATE UserEquipment SET quantity = quantity + :newQuantity WHERE itemType = :itemType")
    suspend fun updateQuantity(itemType: String, newQuantity: Int)

    //get all for equimpment screen
}