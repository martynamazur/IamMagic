package com.example.immagic.nawigation.myprofile.settings

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R

class EditProfile: AppCompatActivity() {

    private lateinit var goBackBtn: ImageButton
    private lateinit var inputNewName: EditText
    private lateinit var saveBtn: Button
    private lateinit var newName: String



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile_layout)

        goBackBtn = findViewById(R.id.goBackBtnEditProfile)
        inputNewName = findViewById(R.id.editTextTextPersonName)
        saveBtn = findViewById(R.id.saveBtnEditProfile)

        newName = inputNewName.text.toString()

        saveBtn.setOnClickListener {

            //wyczysc input
            // zapisz do bazy danych; updatuj username
        }

        goBackBtn.setOnClickListener {
            // Symuluj naciśnięcie przycisku powrotu do wrócenia do poprzedniej aktywności
            // Zakończ bieżącą aktywność i wróć do poprzedniej
            finish()

        }


    }

}
