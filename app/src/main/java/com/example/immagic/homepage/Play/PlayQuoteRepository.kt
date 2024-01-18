package com.example.immagic.homepage.Play

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.immagic.homepage.CourseModel

interface PlayQuoteRepository {

    suspend fun getCourseInformation(): List<CourseModel>
    suspend fun getAllQuotes(cardSetId: Int):List<QuoteModel>

}