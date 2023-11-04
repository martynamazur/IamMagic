package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "NotificationDays",
    foreignKeys = [
        ForeignKey(
            entity = UserCreatedNotifications::class,
            parentColumns = ["id_notification"], // Kolumna klucza głównego w innej tabeli
            childColumns = ["id_notification"], // Kolumna klucza obcego w tej tabeli
            onDelete = ForeignKey.CASCADE, // Zachowanie przy usuwaniu w tabeli nadrzędnej
            onUpdate = ForeignKey.CASCADE // Zachowanie przy aktualizacji w tabeli nadrzędnej
        )]
)
data class NotificationDay(
    @PrimaryKey val id_notification: Int, // Klucz główny
    val Sunday: Boolean,
    val Monday: Boolean,
    val Tuesday: Boolean,
    val Wednesday: Boolean,
    val Thursday: Boolean,
    val Friday: Boolean,
    val Saturday: Boolean
)
