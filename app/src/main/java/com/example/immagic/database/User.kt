package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_user") val idUser: Int = 0,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "user_experience_points") val userExperiencePoints: Int = 0,
    @ColumnInfo(name = "user_level") val userLevel: Int = 0,
    @ColumnInfo(name = "alchemy_points") val alchemyPoints: Int = 0,
    @ColumnInfo(name = "streak") val streak: Int = 0,
    @ColumnInfo(name = "amount_of_cards_read") val amountOfCardsRead: Int = 0,
    @ColumnInfo(name = "amount_of_owned_cards") val amountOfOwnedCards: Int = 0,
    @ColumnInfo(name = "language_version") val languageVersion: String
)
