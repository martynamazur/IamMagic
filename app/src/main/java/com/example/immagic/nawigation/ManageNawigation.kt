package com.example.immagic.nawigation


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.categories.MyCardsFragment
import com.example.immagic.nawigation.favourite.FavouriteFragment
import com.example.immagic.homepage.HomeFragment
import com.example.immagic.nawigation.myprofile.profile.MyProfileFragment
import com.example.immagic.nawigation.notifications.NotificationsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class ManageNawigation : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.basic_nawigation)

        //db test

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setOnItemSelectedListener { item ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.home -> selectedFragment = HomeFragment()
                R.id.favourite -> selectedFragment = FavouriteFragment()
                R.id.notifications -> selectedFragment = NotificationsFragment()
                R.id.cards -> selectedFragment = MyCardsFragment()
                R.id.myProfile -> selectedFragment = MyProfileFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, selectedFragment)
                    .commit()
                supportFragmentManager.executePendingTransactions()
            }
            true
        }


    }
}