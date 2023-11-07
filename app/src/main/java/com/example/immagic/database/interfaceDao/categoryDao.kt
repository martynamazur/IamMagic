package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.Category
import com.example.immagic.database.User

@Dao
interface categoryDao {

    @Insert
    suspend fun insert(category: Category)

    @Query("")
    suspend fun getAllCategories()

    @Query("")
    suspend fun changeCategoryStatus() //niewidoczne kategorie

}