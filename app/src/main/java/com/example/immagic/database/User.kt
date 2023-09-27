package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val id_user: Int = 0,
    val username: String?,
    val user_experience_points: Int,
    val user_level: Int,
    val alchemy_points: Int,
    val streak: Int,
    val amount_of_cards_read: Int,
    val amount_of_owned_cards: Int
)
