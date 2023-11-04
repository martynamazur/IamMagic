package com.example.immagic

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.immagic.database.AppDatabase
import com.example.immagic.first_use.setLanguage.SetFirstLanguage
import com.example.immagic.help.PreferenceHelper
import com.example.immagic.nawigation.ManageNawigation
import kotlinx.coroutines.launch
import java.io.File

class RunController : AppCompatActivity() {
    lateinit var database: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        PreferenceHelper.init(this)



        lifecycleScope.launch {
            try {
                if (PreferenceHelper.isFirstTimeUsage()) {

                    // after first use
                    println("tak 1")
                    val intent = Intent(this@RunController, ManageNawigation::class.java)
                    startActivity(intent)
                    finish() // Zakończ tę aktywność, aby przenieść się do nowej aktywności
                } else {
                    // first use

                    println("nie1")
                    PreferenceHelper.isFirstTimeUsageStatusUpdate()
                    val intent = Intent(this@RunController, SetFirstLanguage::class.java)
                    startActivity(intent)
                    finish() // Zakończ tę aktywność, aby przenieść się do nowej aktywności
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


    }

    }

