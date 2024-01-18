package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TreasureChest")
data class TreasureChest(
    @PrimaryKey @ColumnInfo(name = "chestId") val chestId: Int,
    @ColumnInfo(name = "chestType") val chestType: String,
    @ColumnInfo(name = "price") val price: Int,
    @ColumnInfo(name = "resourceIconId") val resourceIconId: String

)
