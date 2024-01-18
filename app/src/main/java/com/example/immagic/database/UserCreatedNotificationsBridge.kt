package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "UserCreatedNotificationsBridge",)
data class UserCreatedNotificationsBridge(
    @PrimaryKey @ColumnInfo(name = "notificationBridgeId") val notificationBridgeId: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "notificationId") val notificationId: Int
)

