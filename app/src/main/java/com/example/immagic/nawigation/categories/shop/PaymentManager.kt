package com.example.immagic.nawigation.categories.shop

import android.content.Context
import com.example.immagic.database.AppDatabase
import kotlin.coroutines.coroutineContext


enum class ItemType {
    COINS,
    COINS_AND_PUZZLE
}

class PaymentManager(private val shopRepository: ShopRepository, private val context: Context) {

    suspend fun checkBalance(price: Int, puzzleQuantity: Int, itemType: ItemType): Boolean {
        val paymentMethod = when (itemType) {
            ItemType.COINS -> checkSingleCurrencyBalance(shopRepository.getUserCoins(), price)
            ItemType.COINS_AND_PUZZLE -> checkDualCurrencyBalance(
                shopRepository.getUserCoins(),
                shopRepository.getUserPuzzle(),
                price,
                puzzleQuantity
            )
        }
        return paymentMethod ?: false
    }

   fun checkSingleCurrencyBalance(balance: Int, price: Int): Boolean {
        return balance >= price
    }

    fun checkDualCurrencyBalance(coinsBalance: Int, puzzleBalance: Int, price: Int, puzzleQuantity: Int): Boolean {
        return coinsBalance >= price && puzzleBalance >= puzzleQuantity
    }

    suspend fun checkCoinsBalance(price: Int): Boolean {
        val balance = shopRepository.getUserCoins()
        return balance >= price
    }

    suspend fun buyItem(price: Int, puzzleQuantity: Int, itemType: ItemType): Boolean {
        return when (itemType) {
            ItemType.COINS -> buySingleCurrencyItem(price)
            ItemType.COINS_AND_PUZZLE -> buyDualCurrencyItem(price, puzzleQuantity)
        }
    }

    private suspend fun buySingleCurrencyItem(price: Int): Boolean {
        val balance = shopRepository.getUserCoins()
        return if (checkSingleCurrencyBalance(balance, price)) {
                val db = AppDatabase.getInstance(context)
                val user = db.userDao()
                user.updateAlchemyPoints(1, balance - price)
            true
        } else {

            false
        }
    }

    private suspend fun buyDualCurrencyItem(price: Int, puzzleQuantity: Int): Boolean {
        val coinsBalance = shopRepository.getUserCoins()
        val puzzleBalance = shopRepository.getUserPuzzle()

        return if (checkDualCurrencyBalance(coinsBalance, puzzleBalance, price, puzzleQuantity)) {
            val db = AppDatabase.getInstance(context)
            val user = db.userDao()
            user.updateAlchemyPoints(1, coinsBalance - price)
            user.updatePuzzlePoints(1, puzzleBalance - puzzleQuantity)
            true
        } else {
            false
        }
    }



}
