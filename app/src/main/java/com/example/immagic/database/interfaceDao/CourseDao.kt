package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.homepage.CourseModel

@Dao
interface CourseDao {

    @Query("Select * FROM Course WHERE chapterId = :chapterId")
    suspend fun getInformationByChapterId( chapterId: Int): List<CourseModel>

    @Query("UPDATE Course SET lockedStatus = :newStatus WHERE courseId = :courseId")
    suspend fun changeCourseStatus(newStatus: Boolean, courseId: Int)

}