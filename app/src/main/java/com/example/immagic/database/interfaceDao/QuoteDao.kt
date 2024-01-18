package com.example.immagic.database.interfaceDao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.homepage.Play.QuoteModel

@Dao
interface QuoteDao {

    @Query("SELECT * from Quote WHERE cardSetId = :cardSetId")
    suspend fun getAllQuotes(cardSetId: Int): List<QuoteModel>

}