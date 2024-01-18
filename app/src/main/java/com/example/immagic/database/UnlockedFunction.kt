package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "UnlockedFunction")
data class UnlockedFunction(
    @PrimaryKey @ColumnInfo(name = "functionId") val functionId: Int,
    @ColumnInfo(name = "levelId") val levelId: Int,
    @ColumnInfo(name = "functionName") val functionName: String

    )