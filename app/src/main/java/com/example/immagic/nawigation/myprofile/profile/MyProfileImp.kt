package com.example.immagic.nawigation.myprofile.profile

import android.content.Context
import com.example.immagic.database.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyProfileImp(private val context: Context): MyProfileRepository {

    override suspend fun getStreak(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getTotalAmountOfCards(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getTotalReadCards(): Int {
        TODO("Not yet implemented")
    }

    override suspend fun getUserStatisticInfo(): List<ProfileStatisticModel> {
        val statisticList = mutableListOf<ProfileStatisticModel>()

        val applicationContext = context.applicationContext
        val db = AppDatabase.getInstance(applicationContext)
        val userDao = db.userDao()

        val streak = userDao.getStreak(1)
        val totalAmountOfCards = userDao.getTotalAmountOfCards(1)
        val totalReadCards = userDao.getTotalReadCards(1)

        // Tworzenie obiektów ProfileStatisticModel
        statisticList.add(ProfileStatisticModel("Streak", streak.toString()))
        statisticList.add(ProfileStatisticModel("Owned Cards", totalAmountOfCards.toString()))
        statisticList.add(ProfileStatisticModel("Read cards", totalReadCards.toString()))

        return statisticList
    }

    override suspend fun getUsername(): String {
        return try {
            withContext(Dispatchers.IO) {
                val user = AppDatabase.getInstance(context).userDao().getUser(1)
                if (user != null) {
                    val username = user.username
                    println("test $username")
                    "Hello $username"
                } else {
                    "User not found"
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            ":)"
        }
    }




}