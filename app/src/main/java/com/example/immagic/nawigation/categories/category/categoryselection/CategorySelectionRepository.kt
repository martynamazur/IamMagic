package com.example.immagic.nawigation.categories.category.categoryselection

import androidx.lifecycle.LiveData

interface CategorySelectionRepository {

    suspend fun getSubcategories(subCategoryId: Int): List<CategorySelectionModel>
    suspend fun getAllSubcategoriesPrices(): List<SubcategoryPrice>
}