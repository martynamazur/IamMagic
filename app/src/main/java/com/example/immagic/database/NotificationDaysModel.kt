package com.example.immagic.database

import androidx.room.ColumnInfo

data class NotificationDaysModel(
    val id_notification: Int,
    val Sunday: Boolean,
    val Monday: Boolean,
    val Tuesday: Boolean,
    val Wednesday: Boolean,
    val Thursday: Boolean,
    val Friday: Boolean,
    val Saturday: Boolean
)