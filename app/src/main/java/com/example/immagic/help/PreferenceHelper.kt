package com.example.immagic.help

import android.content.Context
import android.content.SharedPreferences

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
}
