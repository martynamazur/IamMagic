package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CardSetPrice")

data class CardSetPrice(
    @PrimaryKey @ColumnInfo(name = "id") val id: Int,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "price") val price: Int
)