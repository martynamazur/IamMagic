package com.example.immagic.help

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent

import android.content.SharedPreferences
import android.os.Build
import com.example.immagic.nawigation.categories.shop.boosts.BoostersItemModel
import java.util.concurrent.TimeUnit

class BoostManager(private val context: Context, private val boostModel: BoostersItemModel) {
    private val preferences: SharedPreferences = context.getSharedPreferences("BoostPreferences", Context.MODE_PRIVATE)
    private val expirationReceiver = BoostExpirationReceiver()

    // Metoda do zapisywania informacji o boostach
    fun saveBoostInfo(boostType: String, durationMillis: Long) {
        val boostDuration = boostModel.boostDuration
        val expirationTime = System.currentTimeMillis() + durationMillis

        // Tutaj zapisz informacje o boostach w SharedPreferences
        //zapisuje id boosta aby potem sprawdzic ktory jest wlaczony
        PreferenceHelper.saveInformationAboutBoost(boostModel.boostId)
        // Ustaw alarm na zakończenie boosta po czasie trwania

        setExpirationAlarm(expirationTime)
    }

    fun convertMinutesToString(minutes: Int): String {
        val hours = TimeUnit.MINUTES.toHours(minutes.toLong())
        val remainingMinutes = minutes - TimeUnit.HOURS.toMinutes(hours)
        val seconds = 0
        //  HH:mm:ss
        return String.format("%02d:%02d:%02d", hours, remainingMinutes, seconds)
    }

    private fun setExpirationAlarm(expirationTime: Long) {
        // Ustawienie alarmu przy użyciu AlarmManager
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, BoostExpirationReceiver::class.java)

        // Utwórz unikalne requestCode, np. na podstawie boostId
        val requestCode = boostModel.boostId.toInt()

        val pendingIntent = PendingIntent.getBroadcast(context, requestCode, intent, 0)

        // Ustaw alarm na zakończenie boosta w określonym czasie
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, expirationTime, pendingIntent)
        } else {
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, expirationTime, pendingIntent)
        }
    }

    fun clearAllBoostInfo() {
        // Wyczyść informacje o boostach w SharedPreferences
        val editor = preferences.edit()
        editor.clear()
        editor.apply()
    }
}
