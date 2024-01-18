package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Subcategory")
data class Subcategory(
    @ColumnInfo(name = "subcategoryId") @PrimaryKey val subcategoryId: Int,
    @ColumnInfo(name = "subcategoryName") val subcategoryName: String,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Int,
    @ColumnInfo(name = "iconPath") val iconPath: String
)
