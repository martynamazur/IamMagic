package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.createquote.CreateNewQuoteModel
import com.example.immagic.createquote.UserCreatedQuote
import com.example.immagic.database.UserCreatedQuotes

@Dao
interface userCreatedQuotes {

    // Dodawanie nowego cytatu
    @Insert
    suspend fun addNewQuote(quote: UserCreatedQuotes)


    // Usuwanie konkretnego cytatu po jego ID
    @Query("DELETE FROM UserCreatedQuotes WHERE id_card = :idQuote")
    suspend fun deleteQuote(idQuote: Int)

    @Query("SELECT id_card, id_user, quote as quoteContent FROM UserCreatedQuotes WHERE id_user = :idUser")
    suspend fun getCreatedQuotes(idUser: Int): List<CreateNewQuoteModel>


}