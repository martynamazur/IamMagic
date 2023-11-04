package com.example.immagic.nawigation.myprofile.settings

import android.content.Context
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.settings.CheckboxListAdapter

class Theme : AppCompatActivity() {

    private lateinit var nawigationBackToSettings : ImageButton
    private lateinit var screenCategoryHeadline : TextView

    private lateinit var themeRc: RecyclerView
    private lateinit var themeObjectList : ArrayList<ItemModelCheckboxIcon>
    private lateinit var itemAdapter : CheckboxListAdapter

    private lateinit var goBackBtn: ImageButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout_basic)

        themeObjectList = ArrayList()
        nawigationBackToSettings = findViewById(R.id.goBackBtn)
        themeRc = findViewById(R.id.themeRc)
        screenCategoryHeadline = findViewById(R.id.screenCategoryHeadline)



        val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val dayTimeisChecked = sharedPreferences.getBoolean("dayTimeisChecked ", false)
        val nightTimeisChecked = sharedPreferences.getBoolean("nightTimeisChecked ", false)

        val dayTimeMode = ItemModelCheckboxIcon("Daytime","sun_icon",dayTimeisChecked)
        val nightTimeMode = ItemModelCheckboxIcon("Night-time","moon_icon",nightTimeisChecked)
        themeObjectList.addAll(listOf(dayTimeMode,nightTimeMode))


        val layoutManager = LinearLayoutManager(this)
        themeRc.layoutManager = layoutManager
        itemAdapter = CheckboxListAdapter(this, themeObjectList, ::onCheckboxClicked)
        themeRc.adapter = itemAdapter

        screenCategoryHeadline.setText(R.string.settings_theme)

        nawigationBackToSettings.setOnClickListener {
            finish()
        }



    }
    private fun onCheckboxClicked(position: Int, isChecked: Boolean) {
        if (isChecked) {
            // Checkbox został zaznaczony
            // Wykonaj odpowiednie działania
        } else {
            // Checkbox został odznaczony
            // Wykonaj inne działania
        }
    }

}