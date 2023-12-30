package com.example.immagic.first_use

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R
import com.example.immagic.nawigation.ManageNawigation

class SetFirstNotification : AppCompatActivity() {

    private  lateinit var continuueBtnSetFirstTime : Button
    private lateinit var continueBtnRemindLatter : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.set_first_notification_layout)

        continuueBtnSetFirstTime = findViewById(R.id.continuueBtnSetFirstTime)
        continueBtnRemindLatter = findViewById(R.id.continueBtnRemindLatter)

        continueBtnRemindLatter.setOnClickListener {
            //kod do bazy danych
            var intent = Intent(this, ManageNawigation::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }

    }
}