package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "LoginHistoryLog",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class LoginHistoryLog(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name="login_history_id" )val loginHistoryId: Int,
    @ColumnInfo(name= "login_time") val time: String,
    @ColumnInfo(name = "user_id") val userId: String
)