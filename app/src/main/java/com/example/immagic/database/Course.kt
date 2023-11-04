package com.example.immagic.database

import androidx.room.*
import com.example.immagic.database.Chapter
import com.example.immagic.database.CourseCardSet

@Entity(
    tableName = "com.example.immagic.database.Course",
    foreignKeys = [
        ForeignKey(
            entity = Chapter::class,
            parentColumns = ["chapter_id"],
            childColumns = ["chapter_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = CourseCardSet::class,
            parentColumns = ["id_cardSet"], // Zmieniono na właściwą kolumnę w CourseCardSet
            childColumns = ["cardSet_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Course(
    @PrimaryKey @ColumnInfo(name = "course_id") val courseId: Int,
    @ColumnInfo(name = "chapter_id") val chapterId: Int,
    @ColumnInfo(name = "cardSet_id") val cardSetId: Int,
    @ColumnInfo(name = "course_name") val courseName: String,
    @ColumnInfo(name = "locked_status") val lockedStatus: Boolean,
    @ColumnInfo(name = "subscription_type") val subscriptionType: Boolean
)
