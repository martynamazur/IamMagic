package com.example.immagic.nawigation.favourite

import com.example.immagic.nawigation.favourite.cardset.FavouriteCardSetModel


interface FavouriteRepository {

    suspend fun getAllFavouriteCards(): List<FavouriteCardsModel>

    suspend fun getTotalNumberOfFavouriteCardSet(): Int

    suspend fun getTotalNumberOfFavouriteCards(): Int
    suspend fun deleteQuoteFromList(quoteId: Int)
    suspend fun getAllFavouriteCardSet(): List<FavouriteCardSetModel>
}