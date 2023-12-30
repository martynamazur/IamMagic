package com.example.immagic.nawigation.categories.shop

import androidx.core.content.ContentProviderCompat.requireContext
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

interface ShopRepository {

    suspend fun getUserCoins(): Int
    suspend fun updateBalanceCoins(newBalance: Int)
    suspend fun updateBalancePuzzle(newBalance: Int)
    suspend fun getUserPuzzle(): Int

}