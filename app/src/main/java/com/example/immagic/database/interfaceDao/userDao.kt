package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.User
import com.example.immagic.help.PreferenceHelper

@Dao
interface userDao {



    @Insert
    suspend fun insert(user: User)

    @Query("SELECT streak FROM User where id_user = :idCurrentUser ")
    suspend fun getStreak(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amount_of_owned_cards FROM User where id_user = :idCurrentUser ")
    suspend fun getTotalAmountOfCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amount_of_cards_read FROM User where id_user = :idCurrentUser ")
    suspend fun getTotalReadCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int
}