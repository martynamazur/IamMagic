package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "LevelBonus")
data class LevelBonus(
   @PrimaryKey @ColumnInfo(name = "levelId") val levelId: Int,
    @ColumnInfo(name = "alchemyLvUpPointsBonus") val alchemyLvUpPointsBonus: Int,
    @ColumnInfo(name = "unlockedCategoryId")val unlockedCategoryId: Int
)
