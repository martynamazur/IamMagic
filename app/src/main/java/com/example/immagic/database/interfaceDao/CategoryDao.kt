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

    @Query("SELECT * FROM Category WHERE unlocked_status = 1")
    suspend fun getAvaiableCategories(): List<CategoryModel>

    @Query("UPDATE Category SET unlocked_status = 1 WHERE id_category = :idCardToUnlock")
    suspend fun changeCategoryStatusToActive(idCardToUnlock: Int)

    @Query("UPDATE Category SET unlocked_status = 0 WHERE id_category = :idCardToLock")
    suspend fun changeCategoryStatusToInActive(idCardToLock: Int)


}