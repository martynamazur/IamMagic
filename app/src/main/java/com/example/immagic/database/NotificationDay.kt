package com.example.immagic.database

import androidx.room.Entity

@Entity(tableName = "NotificationDays", primaryKeys = ["id_notification"])
data class NotificationDay(
    val id_notification: Int, // klucz główny, klucz obcy z tabeli UserCreatedNotifications
    val Sunday: Boolean,
    val Monday: Boolean,
    val Tuesday: Boolean,
    val Wednesday: Boolean,
    val Thursday: Boolean,
    val Friday: Boolean,
    val Saturday: Boolean
)
