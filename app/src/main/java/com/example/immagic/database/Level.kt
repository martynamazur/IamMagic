package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Level")
data class Level(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id_level") val id_level: Int = 0,
    @ColumnInfo(name = "required_points") val requiredPoints: Int,
    @ColumnInfo(name = "alchemy_points") val alchemyPoints: Int,
    @ColumnInfo(name = "unlocked_category_id")val unlockedCategoryId: Int
)
