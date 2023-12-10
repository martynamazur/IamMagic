package com.example.immagic.nawigation.myprofile.settings

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.help.PreferenceHelper
import com.example.immagic.settings.CheckboxListAdapter

class Theme : AppCompatActivity() {

    private lateinit var goBackBtn: ImageButton
    private lateinit var screenCategoryHeadline: TextView
    private lateinit var themeRc: RecyclerView
    private lateinit var itemAdapter: CheckboxListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_layout_basic)

        with(findViewById<ImageButton>(R.id.goBackBtn)) {
            setOnClickListener { finish() }
        }

        screenCategoryHeadline = findViewById(R.id.screenCategoryHeadline)
        themeRc = findViewById(R.id.themeRc)

        val dayTimeisChecked = PreferenceHelper.getDayTimeThemeStatus()
        val nightTimeisChecked = PreferenceHelper.getNightTimeThemeStatus()

        val themeObjectList = arrayListOf(
            ItemModelCheckboxIcon("Daytime", "sun_icon", dayTimeisChecked),
            ItemModelCheckboxIcon("Night-time", "moon_icon", nightTimeisChecked)
        )

        themeRc.apply {
            layoutManager = LinearLayoutManager(this@Theme)
            itemAdapter = CheckboxListAdapter(this@Theme, themeObjectList) { position, isChecked ->
                onCheckboxClicked(position, isChecked)
            }
            adapter = itemAdapter
        }

        screenCategoryHeadline.setText(R.string.settings_theme)
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
