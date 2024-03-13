package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.nawigation.favourite.cardset.FavouriteCardSetModel

@Dao
interface FavouriteCardSetDao {

    @Query("select subcategoryName,Subcategory.subcategoryId,CategoryCardSet.cardSetId, SUbcategory.iconPath from Subcategory JOIN CategoryCardSet ON Subcategory.subcategoryId = CategoryCardSet.subcategoryId where CategoryCardSet.cardSetId IN ( Select cardSetId from FavouriteCardSet )")
    suspend fun getAllCardSet(): List<FavouriteCardSetModel>

    @Query("select count(id) from FavouriteCardSet")
    suspend fun getTotalNumberOfFavCardSet():Int
}