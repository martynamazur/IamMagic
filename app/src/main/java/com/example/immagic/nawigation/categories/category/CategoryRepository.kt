package com.example.immagic.nawigation.categories.category

interface CategoryRepository {

    suspend fun getCategories(): List<CategoryModel>
}