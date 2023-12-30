package com.example.immagic.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "UserCreatedNotifications",
    foreignKeys = [
        ForeignKey(
            entity = CategoryCardSet::class,
            parentColumns = ["cardSetId"],
            childColumns = ["cardSetId"],

        )
    ]
)
data class UserCreatedNotifications(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "notificationId") val notificationId: Int = 0,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "status") val status: Boolean,
    @ColumnInfo(name = "timeStart") val timeStart: String,
    @ColumnInfo(name = "timeEnd") val timeEnd: String,

)
