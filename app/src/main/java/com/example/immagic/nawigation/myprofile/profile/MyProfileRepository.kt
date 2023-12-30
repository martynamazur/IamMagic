package com.example.immagic.nawigation.myprofile.profile

import com.example.immagic.database.interfaceDao.UserDao

 interface MyProfileRepository {

    suspend fun getStreak(): Int
    suspend fun getTotalAmountOfCards(): Int
    suspend fun getTotalReadCards(): Int
    suspend fun getUsername(): String
     suspend fun getUserStatisticInfo(): List<ProfileStatisticModel>

}
