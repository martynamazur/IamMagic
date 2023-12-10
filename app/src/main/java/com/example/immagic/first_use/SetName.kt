package com.example.immagic.first_use

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R

class SetName: AppCompatActivity() {

    private lateinit var continuueBtnEditName : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_name_layout)
        continuueBtnEditName = findViewById(R.id.continueBtnSetName)
        continuueBtnEditName.setOnClickListener {

            //update current user name before launching new activity

            val intent = Intent(this, SetFirstNotification::class.java)
            startActivity(intent)
            finish()
        }
    }

}