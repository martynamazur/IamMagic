package com.example.immagic.homepage.Play

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.immagic.database.AppDatabase
import com.example.immagic.homepage.CourseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PlayQuoteImp(private val context: Context): PlayQuoteRepository{

    override suspend fun getCourseInformation(): List<CourseModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getAllQuotes(cardSetId: Int): List<QuoteModel> {
        return try {
            withContext(Dispatchers.IO){
                val db = AppDatabase.getInstance(context)
                val quoteDao = db.quote()
                quoteDao.getAllQuotes(cardSetId)
            }
        }catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }
    }
}