package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shop")
data class Shop(
    @PrimaryKey @ColumnInfo("card_set_id") val cardSetId: Int,
    @ColumnInfo("price") val price: Int

)