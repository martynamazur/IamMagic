package com.example.immagic.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserCreatedQuotes",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["id_user"]
        )
    ]
)
data class UserCreatedQuotes(
    @PrimaryKey(autoGenerate = true) val id_card: Int = 0,
    val id_user: Int,
    val quote: String
)
