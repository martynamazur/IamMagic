package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.LoginHistoryModel

@Dao
interface LoginHistoryLog {

    @Insert
    suspend fun addNewAppOpenLog(loginHistory: LoginHistoryModel)


    @Query("SELECT * FROM LoginHistoryModel ORDER BY login_history_id DESC LIMIT 2")
    suspend fun getLastTwoLog(): List<LoginHistoryModel>

    @Query("DELETE FROM LoginHistoryModel")
    suspend fun clearLog()
}