package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserCourseProgress"
)
data class UserCourseProgress(
    @PrimaryKey @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "level") val level: Int,
    @ColumnInfo(name = "lessonsCompleted") val lessonsCompleted: Int,
    @ColumnInfo(name = "isEverAttendend") val isEverAttendend: Int
)

