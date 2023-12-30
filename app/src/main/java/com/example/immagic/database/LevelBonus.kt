package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey


@Entity(
    tableName = "LevelBonus",
    foreignKeys = [
        ForeignKey(
            entity = Level::class,
            parentColumns = ["levelId"],
            childColumns = ["levelId"]
        )
    ],
    primaryKeys = ["levelId"]
)
data class LevelBonus(
    @ColumnInfo(name = "levelId") val levelId: Int,
    @ColumnInfo(name = "alchemyLvUpPointsBonus") val alchemyLvUpPointsBonus: Int,
    @ColumnInfo(name = "unlockedCategoryId")val unlockedCategoryId: Int
)
