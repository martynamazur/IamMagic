package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Categories")
data class Category(
    @PrimaryKey val id_category: Int,
    @ColumnInfo(name = "category_name") val categoryName: String?,
    @ColumnInfo(name = "unlocked_status") val unlockedStatus: Int

)
