package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.ForeignKey

@Entity(tableName = "Subcategories_bridge",
    foreignKeys = [
        ForeignKey( entity = Category::class,
        parentColumns = ["id_category"],
        childColumns = ["id_category"]),

        ForeignKey( entity = Subcategory::class,
            parentColumns = ["id_subcategory"],
            childColumns = ["id_subcategory"]),
    ]

)
data class SubcategoriesBridge(
    @ColumnInfo(name = "id_category") val idCategory: Int, // Klucz obcy do tabeli Category
    @ColumnInfo(name = "id_subcategory") val idSubcategory: Int // Klucz obcy do tabeli Subcategory
)
