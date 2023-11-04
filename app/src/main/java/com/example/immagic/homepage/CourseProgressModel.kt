package com.example.immagic.homepage

data class CourseProgressModel(
    val id_userCourseProgress: Int = 0,
    val id_user: Int,
    val id_cardSet: Int,
    val level: Int,
    val level_up_points: Int,
    val isEverAttendent: Boolean,
    val courseName: String
)
