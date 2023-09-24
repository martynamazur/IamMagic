package com.example.immagic.settings

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R


class SetLanguage : AppCompatActivity() {

    private lateinit var nawigationBackToSettings : ImageButton
    private lateinit var screenCategoryHeadline : TextView

    private lateinit var setLanguageRc: RecyclerView
    private lateinit var themeObjectList : ArrayList<ItemModelCheckboxIcon>
    private lateinit var itemAdapter : CheckboxListAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout_basic)

        themeObjectList = ArrayList()
        nawigationBackToSettings = findViewById(R.id.goBackBtn)
        setLanguageRc = findViewById(R.id.themeRc)
        screenCategoryHeadline = findViewById(R.id.screenCategoryHeadline)




        val sharedPreferences = getSharedPreferences("userPref", Context.MODE_PRIVATE)
        val polandisChecked = sharedPreferences.getBoolean("polandisChecked ", false)
        val englishisChecked = sharedPreferences.getBoolean("englishisChecked ", false)

        val englishText = resources.getString(R.string.english_language)
        val polishText = resources.getString(R.string.polish_language)


        val english = ItemModelCheckboxIcon(englishText, "united_kingdom_flag_icon", englishisChecked)
        val polish = ItemModelCheckboxIcon(polishText, "poland_flag_icon", polandisChecked)


        themeObjectList.addAll(listOf(english,polish))


        val layoutManager = LinearLayoutManager(this)
        setLanguageRc.layoutManager = layoutManager
        itemAdapter = CheckboxListAdapter(this, themeObjectList, ::onCheckboxClicked)
        setLanguageRc.adapter = itemAdapter

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