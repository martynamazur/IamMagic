package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserEquipment")
data class UserEquipment(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "itemId") val itemId: Int,
    @ColumnInfo(name = "quantity") val quantity: Int,
    @ColumnInfo(name = "itemType") val itemType: String,
    @ColumnInfo(name = "itemTable") val itemTable: String,
)