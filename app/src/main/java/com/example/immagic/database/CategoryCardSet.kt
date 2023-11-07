package com.example.immagic.database

import androidx.room.*
import com.example.immagic.database.Subcategory

@Entity(
    tableName = "CategoryCardSet",
    foreignKeys = [
        ForeignKey(
            entity = Subcategory::class,
            parentColumns = ["id_subcategory"], // Kolumny klucza głównego w tabeli nadrzędnej
            childColumns = ["idSubcategory"],  // Kolumny klucza obcego w tej tabeli
            onDelete = ForeignKey.CASCADE,      // Zachowanie przy usuwaniu w tabeli nadrzędnej
            onUpdate = ForeignKey.CASCADE      // Zachowanie przy aktualizacji w tabeli nadrzędnej
        )
    ]
)
data class CategoryCardSet(
    @PrimaryKey @ColumnInfo(name = "id_cardSet") val idCardSet: Int,
    @ColumnInfo(name = "idSubcategory") val idSubcategory: Int,
    @ColumnInfo(name = "locked_status") val lockedStatus: Boolean,
    @ColumnInfo(name = "amount") val amount: Int
)
