package com.example.bottomsheettest.database.interf

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.nawigation.categories.category.categoryselection.CategorySelectionModel
import com.example.immagic.nawigation.categories.category.categoryselection.SubcategoryPrice

@Dao
interface SubcategoryDao {

    @Query("SELECT * FROM Subcategory WHERE subcategoryId IN (SELECT subcategoryId FROM SubcategoriesBridge WHERE categoryId = :subCategoryId)")
    suspend fun getAllSubcategories(subCategoryId: Int): List<CategorySelectionModel>


    @Query("SELECT CategoryCardSet.subcategoryId, CardSetPrice.price FROM CategoryCardSet JOIN CardSetPrice ON CategoryCardSet.cardSetId = CardSetPrice.cardSetId WHERE CategoryCardSet.lockedStatus = 2;")
    suspend fun getAllPriceOfSubcategories(): List<SubcategoryPrice>

    @Query("Update Subcategory SET lockedStatus = :newStatus WHERE subcategoryId = :categoryId ")
    suspend fun updateLockedStatus(newStatus: Int, categoryId: Int)


}
