package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserCourseProgress")
data class UserCourseProgress(
    @PrimaryKey(autoGenerate = true) val id_userCourseProgress: Int = 0,
    val id_user: Int, // Klucz obcy do tabeli User
    val id_cardSet: Int, // Klucz obcy do tabeli CourseCardSet
    val level: Int,
    val level_up_points: Int,
    val isEverAttendent: Boolean,
    val courseName: String
)
