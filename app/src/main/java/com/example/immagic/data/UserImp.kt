package com.example.immagic.data

import android.content.Context
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserImp(private val context: Context): UserRepository{

    override suspend fun getStreak(): Int?{
        return try {
            val db = AppDatabase.getInstance(context)
            val user = db.userDao()

            withContext(Dispatchers.IO){
                try{
                    return@withContext user.getStreak(1)
                }finally {
                    db.close()
                }
            }
        }catch (e: Exception){
            e.printStackTrace()
            null
        }

    }

    override suspend fun updateStreak(newStreakValue: Int) {
        TODO("Not yet implemented")
    }

}