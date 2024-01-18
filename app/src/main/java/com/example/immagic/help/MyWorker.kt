package com.example.immagic.help

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

// Tworzenie klasy do realizacji zadania w tle
class MyWorker(context: Context, params: WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        // Tutaj umieść logikę zadania, które ma być wykonane w tle
        return Result.success()
    }
}