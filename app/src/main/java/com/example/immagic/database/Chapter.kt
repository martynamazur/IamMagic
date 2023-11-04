package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Chapter")
data class Chapter(
    @PrimaryKey val chapter_id: Int
)
