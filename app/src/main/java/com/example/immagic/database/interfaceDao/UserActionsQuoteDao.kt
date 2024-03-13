package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.homepage.Play.QuoteActivity
import com.example.immagic.homepage.Play.QuoteActivityModel
import com.example.immagic.nawigation.favourite.FavouriteCardsModel

@Dao
interface UserActionsQuoteDao {

    @Query("Select * from UserActionsQuote where cardSetId = :cardSetId")
    suspend fun getAllInformation(cardSetId: Int): List<QuoteActivityModel>

    @Query("select quoteContent,quoteId from Quote where quoteId in (select quoteId from UserActionsQuote where favouriteStatus == 1)")
    suspend fun getAllFavouriteQuotes(): List<FavouriteCardsModel>
}
