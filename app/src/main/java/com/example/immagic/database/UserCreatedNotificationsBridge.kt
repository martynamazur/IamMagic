package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "UserCreatedNotificationsBridge",
    primaryKeys = ["userId", "notificationId"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"]
        ),
        ForeignKey(
            entity = UserCreatedNotifications::class,
            parentColumns = ["notificationId"],
            childColumns = ["notificationId"]
        )
    ]
)
data class UserCreatedNotificationsBridge(
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "notificationId") val notificationId: Int
)

