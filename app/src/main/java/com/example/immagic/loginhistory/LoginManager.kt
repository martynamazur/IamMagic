package com.example.immagic.loginhistory

import android.content.Context
import com.example.immagic.data.UserImp
import com.example.immagic.data.UserRepository
import java.text.SimpleDateFormat
import java.util.*

class LoginManager(private val context: Context) {

    private val loginRepository: LoginRepository = LoginImp(context)
    private val userRepository: UserRepository = UserImp(context)

    fun isRewardClaimed(){
        // if not show dialog
    }




    suspend fun logInto(): Boolean {
        val today = Date(System.currentTimeMillis())
        val recentLoginString: String? = loginRepository.getLastLoginDate()
        val recentLogin: Date? = if (recentLoginString != null) parseStringToDate(recentLoginString) else null
        val currentStreak: Int = userRepository.getStreak() ?: 0

        if (isFirstLoginToday(today, recentLogin)) {
            if (areLoginsConsecutive(today, recentLogin)) {
                // ... nic nie rób, kolejne logowanie tego samego dnia
                return false
            } else {
                when {
                    areLoginsConsecutive(today, recentLogin) -> {
                        currentStreak.let { userRepository.updateStreak(it + 1) }
                        insertLastLogin(today)
                    }
                    else -> {
                        userRepository.updateStreak(1)
                        insertLastLogin(today)
                    }
                }
                return true
            }
        }
        return false
    }

    private fun parseStringToDate(dateString: String): Date {
        // Tutaj dodaj kod przekształcający String na Date
        // Na przykład możesz użyć SimpleDateFormat
        val format = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
        return format.parse(dateString) ?: Date()
    }



    private fun areLoginsConsecutive(today: Date, recentLogin: Date?): Boolean {
        return today.after(recentLogin)
    }


    private fun isFirstLoginToday(today: Date, recentLogin: Date?): Boolean =
        today == recentLogin

    private suspend fun insertLastLogin(today: Date){
        //val newLogin = LoginHistoryModel(today,1)
        //loginRepository.updateLastLogin(newLogin)
    }
}