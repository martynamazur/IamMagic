package com.example.immagic.database

import androidx.room.*
import com.example.immagic.database.Subcategory

@Entity(
    tableName = "CategoryCardSet",
    foreignKeys = [
        ForeignKey(
            entity = Subcategory::class,
            parentColumns = ["subcategoryId"],
            childColumns = ["subcategoryId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),

    ]
)
data class CategoryCardSet(

    @PrimaryKey @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "subcategoryId") val subcategoryId: Int,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Boolean,
    @ColumnInfo(name = "amount") val amount: Int
)
