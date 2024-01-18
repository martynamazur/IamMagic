package com.example.immagic.help

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

object PreferenceHelper {
    private lateinit var sharedPreferences: SharedPreferences


    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
    }

    fun changeLanguage(languageName: String) {
        val editor = sharedPreferences.edit()
        editor.putString("language", languageName)
        editor.apply()
    }

    fun getSetLanguage(): String {
        return sharedPreferences.getString("language", "en") ?: "en"
    }

    fun isFirstTimeUsage(): Boolean {
        return sharedPreferences.getBoolean("firstUseStatus", false)
    }

    fun isFirstTimeUsageStatusUpdate() {
        val editor = sharedPreferences.edit()
        editor.putBoolean("firstUseStatus", true)
        editor.apply()
    }

    fun getCurrentUserId(): Int {
        return sharedPreferences.getInt("currentUserId",1) ?: 1
    }

    fun getDayTimeThemeStatus(): Boolean {
        return sharedPreferences.getBoolean("dayTimeisChecked", false)
    }

    fun getNightTimeThemeStatus(): Boolean {
        return sharedPreferences.getBoolean("nightTimeisChecked", false)
    }

    fun saveInformationAboutBoost( boostId: Int){
        val editor = sharedPreferences.edit()
        editor.putInt("boostId", boostId)
        editor.apply()
    }

}
