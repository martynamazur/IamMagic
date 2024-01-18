package com.example.bottomsheettest.database

import androidx.room.*

@Entity(
    tableName = "Course",
)
data class Course(
    @PrimaryKey @ColumnInfo(name = "courseId") val courseId: Int,
    @ColumnInfo(name = "chapterId") val chapterId: Int,
    //@ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "courseName") val courseName: String,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Int ,
    @ColumnInfo(name = "subscriptionType") val subscriptionType: Int
)
