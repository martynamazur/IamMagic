package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey @ColumnInfo(name = "userId") val idUser: Int,
    @ColumnInfo(name = "username") val username: String,

    @ColumnInfo(name = "iconResourceId") val iconResourceId: String,

    @ColumnInfo(name = "userExperiencePoints") val userExperiencePoints: Int = 0,
    @ColumnInfo(name = "userLevel") val userLevel: Int = 1,

    @ColumnInfo(name = "alchemyPoints") val alchemyPoints: Int = 0,
    @ColumnInfo(name = "puzzle") val puzzle: Int = 0,
    @ColumnInfo(name = "energyLv") val energyLv: Int =0 ,

    @ColumnInfo(name = "streak") val streak: Int = 0,
    @ColumnInfo(name = "amountOfCardsRead") val amountOfCardsRead: Int = 0,
    @ColumnInfo(name = "amountOfOwnedCards") val amountOfOwnedCards: Int = 0,

)
