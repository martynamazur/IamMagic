package com.example.immagic.loginhistory

import com.example.immagic.database.LoginHistoryModel
import java.util.*

interface LoginRepository {

    suspend fun getLastLoginDate() : String?
    suspend fun getLastTwoDaysLoginDate(): List<LoginHistoryModel>?

    suspend fun updateLastLogin(newLogin: LoginHistoryModel)
}