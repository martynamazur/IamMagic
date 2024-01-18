package com.example.immagic.homepage.Play

data class QuoteActivityModel(
    val id: Long,
    val cardSetId: Int,
    val quoteId: Int,
    val userSoundRecordFileName: String,
    val userSoundStatus: Int,
    val favouriteStatus: Int
)