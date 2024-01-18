package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

import com.example.immagic.database.LoginHistoryModel
import java.util.Date

@Dao
interface LoginHistoryLogDao {

    //@Insert
    //suspend fun addNewAppOpenLog(loginHistory: LoginHistoryModel)

    @Query("SELECT * FROM LoginHistoryLog ORDER BY loginHistoryId DESC LIMIT 2")
    suspend fun getLastTwoLog(): List<LoginHistoryModel>

    @Query("SELECT loginTime FROM LoginHistoryLog ORDER BY loginHistoryId DESC LIMIT 1")
    suspend fun getLastLog(): String


    @Query("DELETE FROM LoginHistoryLog")
    suspend fun clearLog()
}
