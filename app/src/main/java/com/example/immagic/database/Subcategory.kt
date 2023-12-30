package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Subcategory")
data class Subcategory(
    @ColumnInfo(name = "subcategoryId") @PrimaryKey val subcategoryId: Int,
    @ColumnInfo(name = "subcategoryName") val subcategoryName: String,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Boolean
)
