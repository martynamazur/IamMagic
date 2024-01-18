package com.example.immagic.backgroundtasks

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent


class AlarmScheduler(private val context: Context) {

    fun scheduleAlarm(alarmTime: Long) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Set the alarm to trigger at the specified time
        alarmManager.set(
            AlarmManager.RTC_WAKEUP,
            alarmTime,
            pendingIntent
        )
    }

    fun cancelAlarm() {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyAlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        // Cancel the alarm
        alarmManager.cancel(pendingIntent)
    }
}