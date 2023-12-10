package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Rewards")
data class Rewards(

    @PrimaryKey @ColumnInfo(name = "reward_id") val rewardId: Int,
    @ColumnInfo(name = "reward_type") val rewardType: String,
    @ColumnInfo(name = "amount") val amount: Int


)