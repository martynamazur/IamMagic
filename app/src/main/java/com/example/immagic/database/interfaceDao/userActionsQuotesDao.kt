package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.nawigation.favourite.singlecards.manage.LikedQuotesModel

@Dao
interface userActionsQuotesDao {

    @Query("SELECT  Quote.quoteContent, Quote.quote_id FROM Quote INNER JOIN UserActionsQuote ON UserActionsQuote.quote_id = Quote.quote_id WHERE UserActionsQuote.id_user = :userId and added_to_favourite_status = 1")
    fun getLikedQuotes(userId: Int): List<LikedQuotesModel>
}