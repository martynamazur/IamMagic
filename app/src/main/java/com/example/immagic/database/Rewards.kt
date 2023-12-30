package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rewards")
data class Rewards(

    @PrimaryKey @ColumnInfo(name = "rewardId") val rewardId: Int,
    @ColumnInfo(name = "rewardType") val rewardType: String,
    @ColumnInfo(name = "quantity") val amount: Int,
    @ColumnInfo(name = "rewardIconResourceId") val rewardIconResourdeId: Int

)