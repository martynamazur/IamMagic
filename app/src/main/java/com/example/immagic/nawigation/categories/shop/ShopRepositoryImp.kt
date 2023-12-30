package com.example.immagic.nawigation.categories.shop

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.SQLException

class ShopRepositoryImp(private val context: Context)  : ShopRepository{

    override suspend fun getUserCoins(): Int {
        return try {
            withContext(Dispatchers.IO){
                val db = AppDatabase.getInstance(context)
                val user = db.userDao()
                user.getAlchemyPoints(1)
            }
        }catch (e: Exception){
            e.printStackTrace()
            throw e
        }
    }

    override suspend fun updateBalanceCoins(newBalance: Int) {
        withContext(Dispatchers.IO){
            val db = AppDatabase.getInstance(context)
            val user = db.userDao()
            user.updateUserExperiencePoints(1,newBalance)
        }
    }

    override suspend fun updateBalancePuzzle(newBalance: Int) {
        withContext(Dispatchers.IO){
            val db = AppDatabase.getInstance(context)
            val user = db.userDao()
            user.getPuzzle(1)
        }
    }

    override suspend fun getUserPuzzle(): Int {
        return try {
            withContext(Dispatchers.IO) {
                val db = AppDatabase.getInstance(context)
                val user = db.userDao()
                user.getPuzzle(1)
            }
        } catch (sqlException: SQLException) {
            sqlException.printStackTrace()
            throw sqlException
        } catch (e: Exception) {
            e.printStackTrace()
            throw e
        }
    }

}