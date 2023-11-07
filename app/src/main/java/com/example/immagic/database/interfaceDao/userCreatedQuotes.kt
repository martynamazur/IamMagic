package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.createquote.CreateNewQuoteModel
import com.example.immagic.createquote.UserCreatedQuote

@Dao
interface userCreatedQuotes {


    // Dodawanie nowego cytatu
    @Insert
    suspend fun addNewQuote(quote: CreateNewQuoteModel)

    // Usuwanie konkretnego cytatu po jego ID
    @Query("DELETE FROM UserCreatedQuote WHERE id = :idQuote")
    suspend fun deleteQuote(idQuote: Int)

    // Pobieranie listy utworzonych cytatów
    @Query("SELECT * FROM UserCreatedQuote")
    suspend fun getCreatedQuotes(): List<CreateNewQuoteModel>
}