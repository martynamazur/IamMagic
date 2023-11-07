package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LoginHistory {

    @Insert
    suspend fun addNewAppOpenLog(loginHistory: LoginHistoryModel)

    @Query("")
    suspend fun getLastTwoLog()

    @Query("")
    suspend fun clearLog()

}