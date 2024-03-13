package com.example.immagic.nawigation.categories.category.categoryselection

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.immagic.database.AppDatabase

class CategorySelectionImp(private val context: Context): CategorySelectionRepository {

    override suspend fun getSubcategories(subCategoryId: Int): List<CategorySelectionModel> {

        return try {
            val db = AppDatabase.getInstance(context)
            val subcategoryDao = db.subCategory()
            val subcategory = subcategoryDao.getAllSubcategories(subCategoryId)
            subcategory
        }catch (e: Exception){
            e.printStackTrace()
            emptyList()
        }
    }

    override suspend fun getAllSubcategoriesPrices():  List<SubcategoryPrice> {
        return try {
            val db = AppDatabase.getInstance(context)
            val subcategoryDao = db.subCategory()
            val prices = subcategoryDao.getAllPriceOfSubcategories()
            prices

        } catch (e: Exception) {
            e.printStackTrace()
            emptyList()

        }
    }

    override suspend fun updateCategoryAvailability(newStatus: Int, categoryId: Int) {
        val db = AppDatabase.getInstance(context)
        val subcategoryDao = db.subCategory()
        subcategoryDao.updateLockedStatus(newStatus,categoryId)
    }

}