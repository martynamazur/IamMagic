package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Subcategory")
data class Subcategory(
    @PrimaryKey val id_subcategory: Int,
    val subcategory_name: String,
    val locked_status: Boolean
)
