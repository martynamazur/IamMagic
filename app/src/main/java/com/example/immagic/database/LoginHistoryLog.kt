package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "LoginHistoryLog")
data class LoginHistoryLog(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "loginHistoryId") val loginHistoryId: Int,
    @ColumnInfo(name = "loginTime") val loginTime: String
)
