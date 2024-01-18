package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ChestReward",)
data class ChestReward(

    @PrimaryKey @ColumnInfo(name = "rewardId") val rewardId: Int,
    @ColumnInfo(name = "chestId") val chestId: Int,


)