package com.example.immagic

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

import com.example.immagic.nawigation.HomeFragment
import com.example.immagic.settings.SetLanguage

class Run : AppCompatActivity(){

    @SuppressLint("CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        val tekst = "To jest przykładowy tekst do wyświetlenia"
        println(tekst)

        val sharedPreferences: SharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val hasKey = sharedPreferences.contains("hasOpenedForTheFirstTime")

        if (hasKey){
            //val intent = Intent(this, HomeFragment::class.java)
            //startActivity(intent)
            println("debil")
        } else {
            val intent = Intent(this, SetLanguage::class.java)
            startActivity(intent)

            val tekst2 = "To jest przykładowy tekst do wyświetlenia2"
            println(tekst2)}

}}