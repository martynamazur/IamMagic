package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "ChestReward",
foreignKeys = [
    ForeignKey(
        entity = TreasureChest::class,
        parentColumns = ["chestId"],
        childColumns = ["chest_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE

    ),
    ForeignKey(
        entity = Rewards::class,
        parentColumns = ["reward_id"],
        childColumns = ["reward_id"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )

]
)
data class ChestReward(

    @PrimaryKey @ColumnInfo(name = "reward_id") val rewardId: Int,
    @ColumnInfo(name = "chest_id") val chestId: Int,


)