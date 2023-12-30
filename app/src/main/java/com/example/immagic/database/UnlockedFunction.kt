package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(tableName = "UnlockedFunction",
    foreignKeys = [
        ForeignKey(
            entity = Level::class,
            parentColumns = ["levelId"],
            childColumns = ["levelId"]
        )
    ],
    primaryKeys = ["levelId"])
data class UnlockedFunction(
    @ColumnInfo(name = "levelId") val levelId: Int,
    @ColumnInfo(name = "functionName") val functionName: String

    )