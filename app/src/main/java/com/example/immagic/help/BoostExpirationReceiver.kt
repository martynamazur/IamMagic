package com.example.immagic.help

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class BoostExpirationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        // Tutaj umieść kod, który ma zostać wykonany po zakończeniu czasu trwania boosta
        // Na przykład, możesz wyczyścić dane z SharedPreferences
        //val boostManager = BoostManager(context!!)
        //boostManager.clearAllBoostInfo()
    }
}

