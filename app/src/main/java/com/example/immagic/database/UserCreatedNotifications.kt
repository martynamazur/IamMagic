package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserCreatedNotifications")
data class UserCreatedNotifications(
    @PrimaryKey(autoGenerate = true) val id_notification: Int = 0,
    val id_cardSet: Int, // Klucz obcy do tabeli CategoryCardSet
    val status: Boolean,
    val time: String, // Godzina i minuta jako tekst (np. "10:30")
    val time_end: String // Godzina i minuta jako tekst (np. "11:00")
)
