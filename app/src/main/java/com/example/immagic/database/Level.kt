package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
//all existing levels
@Entity(tableName = "Level")
data class Level(
    @PrimaryKey @ColumnInfo(name = "levelId") val levelId: Int,
    @ColumnInfo(name = "requiredPoints") val requiredPoints: Int,

)
