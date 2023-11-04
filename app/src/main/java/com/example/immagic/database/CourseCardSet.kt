package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "CourseCardSet",
    foreignKeys = [
        ForeignKey(
            entity = Course::class,
            parentColumns = ["course_id"], // Kolumny klucza głównego w tabeli Chapter
            childColumns = ["course_id"],  // Kolumny klucza obcego w tej tabeli
            onDelete = ForeignKey.CASCADE,      // Zachowanie przy usuwaniu w tabeli nadrzędnej
            onUpdate = ForeignKey.CASCADE      // Zachowanie przy aktualizacji w tabeli nadrzędnej
        )
    ]
)


data class CourseCardSet(
    @PrimaryKey @ColumnInfo(name = "id_cardSet") val id_cardSet: Int,
    @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "card_set_name") val cardSetName: String?)