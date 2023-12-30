package com.example.immagic.homepage

data class CourseModel(
    val chapterId: Int,
    val courseId: Int,
    val courseName: String,
    val lockedStatus: Boolean,
    val subscriptionType: String
)