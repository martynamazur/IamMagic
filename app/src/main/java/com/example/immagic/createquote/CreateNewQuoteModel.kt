package com.example.immagic.createquote

import androidx.room.Entity


data class CreateNewQuoteModel(

    val id_user: Int,
    val quoteContent: String
)
