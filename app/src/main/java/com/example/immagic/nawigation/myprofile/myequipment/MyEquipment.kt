package com.example.immagic.nawigation.myprofile.myequipment

import android.os.Bundle

import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

import com.example.immagic.R

class MyEquipment: AppCompatActivity() {

    private lateinit var equipmentRc: RecyclerView
    private lateinit var equipmentGoBackBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_equipment)


        equipmentRc = findViewById(R.id.equipmentRc)
        equipmentGoBackBtn = findViewById(R.id.equipmentGoBackBtn)

        equipmentGoBackBtn.setOnClickListener { finish() }
    }
}