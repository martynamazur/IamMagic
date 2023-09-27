package com.example.immagic.database

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Level",
    foreignKeys = [
        ForeignKey(
            entity = Category::class,
            parentColumns = ["id_category"],
            childColumns = ["unlocked_category_id"]
        )
    ]
)
data class Level(
    @PrimaryKey(autoGenerate = true) val id_level: Int = 0,
    val required_points: Int,
    val alchemy_points: Int,
    val unlocked_category_id: Int
)
