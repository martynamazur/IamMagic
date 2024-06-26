package com.example.bottomsheettest.database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "SubcategoriesBridge")
data class SubcategoriesBridge(
    @PrimaryKey @ColumnInfo(name = "bridgeId") val bridgeId: Int,
    @ColumnInfo(name = "categoryId") val categoryId: Int,
    @ColumnInfo(name = "subcategoryId") val subcategoryId: Int
)
