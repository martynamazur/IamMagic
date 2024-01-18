package com.example.immagic.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "UserCreatedNotifications")
data class UserCreatedNotifications(


    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "notificationId") val notificationId: Int,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "status") val status: Int,
    @ColumnInfo(name = "timeStart") val timeStart: String,
    @ColumnInfo(name = "timeEnd") val timeEnd: String,

)
