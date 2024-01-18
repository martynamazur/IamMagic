package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "CourseCardSet")
data class CourseCardSet(
    @PrimaryKey @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "courseId") val courseId: Int,

)
