package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.Category
import com.example.immagic.nawigation.categories.category.CategoryModel

@Dao
interface CategoryDao {

    @Insert
    suspend fun insert(category: Category)

    @Query("SELECT * FROM Category WHERE availability = 1")
    suspend fun getAvaiableCategories(): List<CategoryModel>

    @Query("UPDATE Category SET availability = 1 WHERE categoryId = :idCardToUnlock")
    suspend fun changeCategoryStatusToActive(idCardToUnlock: Int)

    @Query("UPDATE Category SET availability = 0 WHERE categoryId = :idCardToLock")
    suspend fun changeCategoryStatusToInActive(idCardToLock: Int)


}