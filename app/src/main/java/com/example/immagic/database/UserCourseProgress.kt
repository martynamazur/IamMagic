package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserCourseProgress")
data class UserCourseProgress(
    @PrimaryKey @ColumnInfo(name = "id_user_course_progress") val id_userCourseProgress: Int = 0,
    @ColumnInfo(name = "id_user")  val id_user: Int,
    @ColumnInfo(name = "id_card_set") val id_cardSet: Int,
    @ColumnInfo(name = "level") val level: Int,
    @ColumnInfo(name = "level_up_points") val level_up_points: Int,
    @ColumnInfo(name = "is_ever_attendend") val isEverAttendend: Int,

)
