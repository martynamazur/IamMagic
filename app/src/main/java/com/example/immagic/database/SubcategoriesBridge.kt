package com.example.immagic.database

import androidx.room.Entity
import androidx.room.ColumnInfo
import androidx.room.ForeignKey

@Entity(tableName = "Subcategories_bridge",
    foreignKeys = [
        ForeignKey( entity = Category::class,
        parentColumns = ["categoryId"],
        childColumns = ["categoryId"]),

        ForeignKey( entity = Subcategory::class,
            parentColumns = ["subcategoryId"],
            childColumns = ["subcategoryId"]),
    ]

)
data class SubcategoriesBridge(
    @ColumnInfo(name = "categoryId") val categoryId: Int, // Klucz obcy do tabeli Category
    @ColumnInfo(name = "subcategoryId") val subcategoryId: Int // Klucz obcy do tabeli Subcategory
)
