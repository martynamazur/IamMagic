package com.example.immagic.database

import androidx.room.*

@Entity(
    tableName = "Course",
    foreignKeys = [

        ForeignKey(
            entity = CourseCardSet::class,
            parentColumns = ["cardSetId"],
            childColumns = ["cardSetId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["cardSetId"], unique = true)]
)
data class Course(
    @PrimaryKey @ColumnInfo(name = "courseId") val courseId: Int,
    @ColumnInfo(name = "chapterId") val chapterId: Int,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "courseName") val courseName: String,
    @ColumnInfo(name = "lockedStatus") val lockedStatus: Boolean,
    @ColumnInfo(name = "subscriptionType") val subscriptionType: Boolean
)
