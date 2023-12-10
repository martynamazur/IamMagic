package com.example.immagic.nawigation.categories.category

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.immagic.database.AppDatabase

class CategoryRepositoryImp(private val context: Context): CategoryRepository {

    override suspend fun getCategories(): List<CategoryModel> {
        return try {
            val db = AppDatabase.getInstance(context)
            val categoryDao = db.category()
            val categories = categoryDao.getAvaiableCategories()
            categories
        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()
        }
    }
}