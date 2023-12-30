package com.example.immagic.Play

import com.example.immagic.homepage.CourseModel

interface PlayQuoteRepository {

    suspend fun getCourseInformation(): List<CourseModel>
}