package com.example.immagic.data

import android.content.Context
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface UserRepository {

    suspend fun getStreak(): Int?
    suspend fun updateStreak( newStreakValue: Int)
}