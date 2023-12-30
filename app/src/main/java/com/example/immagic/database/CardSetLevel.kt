package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CardSetLevel")
data class CardSetLevel(
    @PrimaryKey @ColumnInfo(name = "cardSetLv") val cardSetLv: Int,
    @ColumnInfo(name = "lessonsCompletedToLvUp") val lessonsCompletedToLvUp: Int,
    @ColumnInfo(name = "levelType") val levelType: String
)
