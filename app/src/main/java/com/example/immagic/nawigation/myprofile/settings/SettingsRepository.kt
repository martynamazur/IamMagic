package com.example.immagic.nawigation.myprofile.settings



interface SettingsRepository {

    //EditProfile
    suspend fun updateUsername(newUsername: String)
    suspend fun updateUserIcon(newIcon: String)


}