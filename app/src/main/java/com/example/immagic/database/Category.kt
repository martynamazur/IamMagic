package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Category")
data class Category(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "categoryId") val categoryId: Int,
    @ColumnInfo(name = "categoryName") val categoryName: String,
    @ColumnInfo(name = "availability") val availability: Boolean,
    @ColumnInfo(name = "iconPath") val iconPath: String, // TODO chyba int

)
