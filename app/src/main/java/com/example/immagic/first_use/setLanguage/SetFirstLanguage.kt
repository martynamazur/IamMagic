package com.example.immagic.first_use.setLanguage

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room.databaseBuilder
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.User
import com.example.immagic.help.PreferenceHelper
import com.example.immagic.onboarding.OnBoardingActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import kotlin.collections.ArrayList

class SetFirstLanguage : AppCompatActivity() {

    private lateinit var continueBtnSetLanguageFirstTime: Button
    private lateinit var languageListRc: RecyclerView
    private lateinit var languageAdapter: LanguageAdapter
    private var languageList = mutableListOf(
        LanguageModel("pl", "Poland", "poland_flag_icon"),
        LanguageModel("en", "English", "united_kingdom_flag_icon")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_language_first_time)

        continueBtnSetLanguageFirstTime = findViewById(R.id.continueBtnF)
        languageListRc = findViewById(R.id.langageListRc)
        languageAdapter = LanguageAdapter(this, languageList as ArrayList<LanguageModel>)

        val layoutManager = LinearLayoutManager(this)
        languageListRc.layoutManager = layoutManager
        languageListRc.adapter = languageAdapter

        continueBtnSetLanguageFirstTime.setOnClickListener {
            val selectedLanguage = languageAdapter.getSelectedLanguage()
            PreferenceHelper.changeLanguage(selectedLanguage.toString())
            saveUserAndChangeLanguage(selectedLanguage.toString())
        }
    }

    private fun saveUserAndChangeLanguage(language: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = AppDatabase.getInstance(applicationContext)

                val userDao = db.userDao()
                val newUser = User(username = "", languageVersion = language)
                userDao.insert(newUser)
                changeAppLanguage(language)
            }
            startOnboardingActivity()
        }
    }


    private fun changeAppLanguage(languageCode: String) {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val resources = resources
        val configuration = Configuration(resources.configuration)
        configuration.setLocale(locale)

        //resources.updateConfiguration(configuration, resources.displayMetrics)
    }

    private fun startOnboardingActivity() {
        val intent = Intent(this, OnBoardingActivity::class.java)
        startActivity(intent)
        finish()
    }



}
