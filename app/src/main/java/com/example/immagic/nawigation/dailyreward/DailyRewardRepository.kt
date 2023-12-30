package com.example.immagic.nawigation.dailyreward

interface DailyRewardRepository {

    suspend fun updateStreak( newValue: Int)
    suspend fun updateInventory()
}