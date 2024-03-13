package com.example.immagic.nawigation.myprofile.profile

interface MyProfileRepository {

    suspend fun getStreak(): Int
    suspend fun getTotalAmountOfCards(): Int
    suspend fun getTotalReadCards(): Int
    suspend fun getUsername(): String
     suspend fun getUserStatisticInfo(): List<ProfileStatisticModel>

     //przeniesc pozniej
     suspend fun getWalletBalance(): Int

     suspend fun updateWalletBalance(newBalance: Int)

}
