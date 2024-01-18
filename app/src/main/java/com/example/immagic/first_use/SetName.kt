package com.example.immagic.first_use

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.bottomsheettest.database.User
import com.example.immagic.R
import com.example.immagic.database.AppDatabase

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SetName: AppCompatActivity() {

    private lateinit var continuueBtnEditName : Button
    private lateinit var inputNewName: EditText


    //TODO: oddzielic logike
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_name_layout)

        continuueBtnEditName = findViewById(R.id.continueBtnSetName)
        inputNewName = findViewById(R.id.inputNewNameFT)

        continuueBtnEditName.setOnClickListener {
            lifecycleScope.launch {
                withContext(Dispatchers.IO){
                    saveUser(inputNewName.text.toString())
                }
            }

            val intent = Intent(this, SetFirstNotification::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun saveUser(username: String) {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val db = AppDatabase.getInstance(applicationContext)
                val userDao = db.userDao()
                val newUser = User(1,"mati","icon",)
                userDao.insert(newUser)

            }

        }
    }

}