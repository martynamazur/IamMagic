package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.immagic.database.User
import com.example.immagic.help.PreferenceHelper

@Dao

interface userDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT username FROM User where id_user = :idCurrentUser")
    suspend fun getUsername(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): String

    @Query("SELECT user_level FROM User where id_user = :idCurrentUser")
    suspend fun getUserLv(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT user_experience_points FROM User where id_user = :idCurrentUser")
    suspend fun getUserExperiencePoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT alchemy_points FROM User WHERE id_user = :idCurrentUser")
    suspend fun getAlchemyPoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT streak FROM User where id_user = :idCurrentUser ")
    suspend fun getStreak(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amount_of_owned_cards FROM User where id_user = :idCurrentUser ")
    suspend fun getTotalAmountOfCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amount_of_cards_read FROM User where id_user = :idCurrentUser ")
    suspend fun getTotalReadCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("UPDATE User SET username = :newValue where id_user = :idCurrentUser")
    suspend fun updateUsername(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: String)

    @Query("UPDATE User SET user_experience_points = :newValue where id_user = :idCurrentUser")
    suspend fun updateUserExperiencePoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET streak = :newValue where id_user = :idCurrentUser")
    suspend fun updateStreak(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET user_level = :newValue where id_user = :idCurrentUser")
    suspend fun updateUserLevel(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET amount_of_cards_read = :newValue where id_user = :idCurrentUser")
    suspend fun updateAllReadCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET amount_of_owned_cards = :newValue where id_user = :idCurrentUser")
    suspend fun updateOwnedCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)
}



