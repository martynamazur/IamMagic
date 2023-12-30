package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Level")
data class Level(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "levelId") val levelId: Int = 1,
    @ColumnInfo(name = "requiredPoints") val requiredPoints: Int,

)
