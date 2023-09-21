package com.example.immagic.first_use

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R
import com.example.immagic.onboarding.OnBoardingActivity


class SetLanguage : AppCompatActivity() {

    private lateinit var continuueBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.set_language_first_time)
        continuueBtn = findViewById(R.id.continuueBtnSetLanguageFirstTime)
        continuueBtn.setOnClickListener {
            val intent = Intent(this, SetName::class.java)
            startActivity(intent)
        }
    }
}