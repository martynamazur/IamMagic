package com.example.immagic.Play

data class SetDataModel (

    // Tabelka kursy | id setu kart | ilosc kart | nazwa kursu
    val amountOfCards: Int,
    val cardSetId: Int,
    val courseName: String,

    //Tabelka zawartosc setu kursu nr 4 | cytat | status polajkowania
    val quoteContent: String,
    val faouriteStatus: Boolean,
    val myOwnRecordStatus: Boolean,
    val defaultRecord: String,
    val myOwnrecord: String //nazwa nagrania lub id

        )