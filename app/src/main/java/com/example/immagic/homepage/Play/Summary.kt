package com.example.immagic.homepage.Play

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R
import com.example.immagic.nawigation.ManageNawigation

class Summary: AppCompatActivity() {

    private lateinit var continueBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.summary_layout)
        continueBtn = findViewById(R.id.button4)

        continueBtn.setOnClickListener {
            val intent = Intent(this, ManageNawigation::class.java)
            startActivity(intent)
        }
    }
}
