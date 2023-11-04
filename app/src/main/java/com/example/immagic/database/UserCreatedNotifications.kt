package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserCreatedNotifications")
data class UserCreatedNotifications(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_notification") val id_notification: Int = 0,
    @ColumnInfo(name = "id_cardSet") val idCardSet: Int, // Klucz obcy do tabeli CategoryCardSet
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "time_start") val timeStart: String, // Godzina i minuta jako tekst (np. "10:30")
    @ColumnInfo(name = "time_end") val timeEnd: String, // Godzina i minuta jako tekst (np. "11:00")
    @ColumnInfo(name = "time_start_indicator") val timeStartIndicator: String, //am or pm
    @ColumnInfo(name = "time_end_indicator") val timeEndIndicator: String,
    @ColumnInfo(name = "name") val name: String
)
