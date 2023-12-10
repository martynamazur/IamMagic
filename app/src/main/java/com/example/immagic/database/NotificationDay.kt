package com.example.immagic.database

import androidx.room.ColumnInfo
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
    @PrimaryKey @ColumnInfo("id_notification") val id_notification: Int, // Klucz główny
    @ColumnInfo(name = "sunday") val Sunday: Int,
    @ColumnInfo(name = "monday") val Monday: Int,
    @ColumnInfo(name = "thuesday") val Tuesday: Int,
    @ColumnInfo(name = "wednesday") val Wednesday: Int,
    @ColumnInfo(name = "thursday") val Thursday: Int,
    @ColumnInfo(name = "friday") val Friday: Int,
    @ColumnInfo(name = "saturday") val Saturday: Int

)
