package com.example.immagic.onboarding

import OnBoardingPagerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.example.immagic.R
import com.example.immagic.first_use.SetName

class OnBoardingActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2
    private lateinit var pagerAdapter: OnBoardingPagerAdapter

    private lateinit var skipBtn: Button
    private lateinit var nextFrameBtn: Button

    // Ustaw to na true, jeśli chcesz użyć ekranu niestandardowego, w przeciwnym razie użyj ekranu standardowego.
    //private val isCustomScreen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.onboarding_layout)


        // included layout
        val includedLayout = findViewById<View>(R.id.onboarding_bottom_controls)
        skipBtn = includedLayout.findViewById(R.id.skipBtn)
        nextFrameBtn = includedLayout.findViewById(R.id.nextFrameBtn)



        viewPager = findViewById(R.id.viewPager2)
        pagerAdapter = OnBoardingPagerAdapter(this)
        viewPager.adapter = pagerAdapter


        skipBtn.setOnClickListener {
            val intent = Intent(this, SetName::class.java)
            startActivity(intent)
            finish()
        }
        nextFrameBtn.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + 1
            if (viewPager.currentItem == 3){
                includedLayout.visibility = View.INVISIBLE
            }else{
                includedLayout.visibility = View.VISIBLE
            }
        }
    }
}
