package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserCreatedQuotes",)
data class UserCreatedQuotes(
    @PrimaryKey(autoGenerate = true) val cardId: Int = 0,
    @ColumnInfo(name = "quote")val quote: String
)
