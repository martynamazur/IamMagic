package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "UserCreatedNotificationsBridge",
    primaryKeys = ["id_user", "id_notification"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["id_user"]
        ),
        ForeignKey(
            entity = UserCreatedNotifications::class,
            parentColumns = ["id_notification"],
            childColumns = ["id_notification"]
        )
    ]
)
data class UserCreatedNotificationsBridge(
    @ColumnInfo(name="id_user") val idUser: Int,
    @ColumnInfo(name="notification_id") val notificationId: Int
)
