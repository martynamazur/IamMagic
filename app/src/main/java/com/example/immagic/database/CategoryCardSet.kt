package com.example.immagic.database

import androidx.room.*
import com.example.immagic.database.Subcategory

@Entity(
    tableName = "CategoryCardSet",
    foreignKeys = [
        ForeignKey(
            entity = Subcategory::class,
            parentColumns = ["id_subcategory"],
            childColumns = ["idSubcategory"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
      //pomyslec
    ]
)
data class CategoryCardSet(

    @PrimaryKey @ColumnInfo(name = "id_cardSet") val idCardSet: Int,
    @ColumnInfo(name = "idSubcategory") val idSubcategory: Int,
    @ColumnInfo(name = "locked_status") val lockedStatus: Boolean,
    @ColumnInfo(name = "amount") val amount: Int
)
