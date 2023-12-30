package com.example.immagic.loginhistory

import android.content.Context
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.LoginHistoryModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*

class LoginImp(private val context: Context): LoginRepository {

    override suspend fun getLastLoginDate(): String? {
        return try {
            val db = AppDatabase.getInstance(context)
            val loginHistory = db.loginHistoryLog()

            withContext(Dispatchers.IO) {
                try {
                    return@withContext loginHistory.getLastLog()
                } finally {
                    db.close()
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

    override suspend fun getLastTwoDaysLoginDate(): List<LoginHistoryModel>?{
        return try {
            val db = AppDatabase.getInstance(context)
            val loginHistory = db.loginHistoryLog()
            withContext(Dispatchers.IO){
                try {
                    return@withContext loginHistory.getLastTwoLog()
                }finally {
                    db.close()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
            null
        }

    }

    override suspend fun updateLastLogin(newLogin: LoginHistoryModel) {
        try{
            val db = AppDatabase.getInstance(context)
            val loginHistory = db.loginHistoryLog()

            withContext(Dispatchers.IO){
                //TODO wrocic i odkomentowac updatowanie nie dziala
                //loginHistory.addNewAppOpenLog(newLogin)
            }

        }catch (e: Exception){
            e.printStackTrace()
        }
    }
}