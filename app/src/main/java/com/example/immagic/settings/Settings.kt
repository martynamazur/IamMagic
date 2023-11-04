/*
package com.example.immagic.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.settings.SettingsAdapter
import com.example.immagic.nawigation.myprofile.settings.SettingsModel

class Settings : AppCompatActivity() {

    private lateinit var settingsListRc : RecyclerView
    private lateinit var settingsAdapter: SettingsAdapter

    private lateinit var settingsListObject :  ArrayList<SettingsModel>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)


        settingsListRc = findViewById(R.id.settingsListRc)



        settingsListObject = ArrayList()
        val editProfil = SettingsModel(resources.getString(R.string.settings_edit_profile),"sun")
        val theme = SettingsModel(resources.getString(R.string.settings_theme),"sun")
        val privacyPolicy = SettingsModel(resources.getString(R.string.settings_privacy_policy),"sun")
        val rateUs = SettingsModel(resources.getString(R.string.settings_rate_us),"sun")
        val credits = SettingsModel(resources.getString(R.string.settings_credits),"sun")
        val aboutUs = SettingsModel(resources.getString(R.string.settings_about_app),"sun")
        val resetProgress= SettingsModel(resources.getString(R.string.settings_reset_progress),"sun")

        settingsListObject.addAll(listOf(editProfil,theme,privacyPolicy,rateUs,credits,aboutUs,resetProgress))


        val layoutManager = LinearLayoutManager(this)
        settingsListRc.layoutManager = layoutManager
        settingsAdapter = SettingsAdapter(this, settingsListObject)
        settingsListRc.adapter = settingsAdapter






    }

}

 */


