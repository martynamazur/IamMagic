package com.example.immagic.database

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.homepage.Play.QuoteActivity
import com.example.immagic.homepage.Play.QuoteActivityModel

@Dao
interface UserActionsQuoteDao {

    @Query("Select * from UserActionsQuote where cardSetId = :cardSetId")
    suspend fun getAllInformation(cardSetId: Int): List<QuoteActivityModel>

}
