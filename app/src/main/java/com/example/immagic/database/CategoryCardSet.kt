package com.example.bottomsheettest.database

import androidx.room.*


@Entity(
    tableName = "CategoryCardSet")
data class CategoryCardSet(

    @PrimaryKey @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "subcategoryId") val subcategoryId: Int,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Int,

)
