package com.example.immagic.nawigation.myprofile.settings

import android.content.Context
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SettingsImpl(private val context: Context): SettingsRepository{

    override suspend fun updateUsername(newUsername: String) {


        withContext(Dispatchers.IO){
            val db = AppDatabase.getInstance(context)
            val userDao = db.userDao()
            userDao.updateUsername(1, newUsername)
        }
    }

    override suspend fun updateUserIcon(newIcon: String) {
        withContext(Dispatchers.IO){
            val db = AppDatabase.getInstance(context)
            val userDao = db.userDao()
            userDao.updateIcon(1,newIcon)
        }
    }


}