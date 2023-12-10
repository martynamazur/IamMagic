package com.example.immagic.database.interfaceDao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.database.TreasureChest
import com.example.immagic.nawigation.categories.shop.treasurechest.TreasureChestModel

@Dao
interface TreasureChestDao {

    @Query("SELECT * FROM TreasureChest WHERE chestId = :chestId")
    suspend fun getInformationAboutChest(chestId: Int): TreasureChestModel?


}