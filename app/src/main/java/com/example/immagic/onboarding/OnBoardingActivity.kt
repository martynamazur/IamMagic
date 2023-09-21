package com.example.immagic.onboarding

import OnBoardingPagerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.immagic.R

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: OnBoardingPagerAdapter

    // Ustaw to na true, jeśli chcesz użyć ekranu niestandardowego, w przeciwnym razie użyj ekranu standardowego.
    private val isCustomScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_layout)

        // Inicjalizacja ViewPager i Adaptera
        viewPager = findViewById(R.id.viewPager2) // Zmień R.id.viewPager2 na właściwy identyfikator ViewPager2
        pagerAdapter = OnBoardingPagerAdapter(this)
        viewPager.adapter = pagerAdapter
    }
}
