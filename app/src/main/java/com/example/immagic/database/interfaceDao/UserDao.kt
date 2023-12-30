package com.example.immagic.database.interfaceDao

import android.net.Uri
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.User
import com.example.immagic.help.PreferenceHelper

@Dao

interface UserDao {

    @Insert
    suspend fun insert(user: User)

    @Query("SELECT username FROM User where userId = :idCurrentUser")
    suspend fun getUsername(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): String

    @Query("SELECT userLevel FROM User where userId = :idCurrentUser")
    suspend fun getUserLv(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT userExperiencePoints FROM User where userId = :idCurrentUser")
    suspend fun getUserExperiencePoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT alchemyPoints FROM User WHERE userId = :idCurrentUser")
    suspend fun getAlchemyPoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT puzzle FROM User WHERE userId = :idCurrentUser")
    suspend fun getPuzzle(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int


    @Query("SELECT streak FROM User where userId = :idCurrentUser ")
    suspend fun getStreak(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amountOfOwnedCards FROM User where userId = :idCurrentUser ")
    suspend fun getTotalAmountOfCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int

    @Query("SELECT amountOfCardsRead FROM User where userId = :idCurrentUser ")
    suspend fun getTotalReadCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId()): Int


    @Query("UPDATE User SET username = :newValue where userId = :idCurrentUser")
    suspend fun updateUsername(idCurrentUser: Int, newValue: String)

    @Query("UPDATE User SET iconResourceId = :newValue where userId = :idCurrentUser")
    suspend fun updateIcon(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: String)


    @Query("UPDATE User SET alchemyPoints = :newValue where userId = :idCurrentUser")
    suspend fun updateAlchemyPoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET puzzle = :newValue where userId = :idCurrentUser")
    suspend fun updatePuzzlePoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET userExperiencePoints = :newValue where userId = :idCurrentUser")
    suspend fun updateUserExperiencePoints(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET streak = :newValue where userId = :idCurrentUser")
    suspend fun updateStreak(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET userLevel = :newValue where userId = :idCurrentUser")
    suspend fun updateUserLevel(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET amountOfCardsRead = :newValue where userId = :idCurrentUser")
    suspend fun updateAllReadCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)

    @Query("UPDATE User SET amountOfOwnedCards = :newValue where userId = :idCurrentUser")
    suspend fun updateOwnedCards(idCurrentUser: Int = PreferenceHelper.getCurrentUserId(), newValue: Int)
}



