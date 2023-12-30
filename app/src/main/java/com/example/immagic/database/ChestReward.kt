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
        childColumns = ["chestId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE

    ),
    ForeignKey(
        entity = Rewards::class,
        parentColumns = ["rewardId"],
        childColumns = ["rewardId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )

]
)
data class ChestReward(

    @PrimaryKey @ColumnInfo(name = "rewardId") val rewardId: Int,
    @ColumnInfo(name = "chestId") val chestId: Int,


)