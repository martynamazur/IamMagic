package com.example.immagic.nawigation.myprofile.settings

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R

class PrivacyPolicy:AppCompatActivity() {

    private lateinit var goBackToSettings : ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.privacy_policy_layout)
        goBackToSettings = findViewById(R.id.goBackBtn)


        goBackToSettings.setOnClickListener {
            finish()
        }
    }
}