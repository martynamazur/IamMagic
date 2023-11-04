package com.example.immagic.nawigation.favourite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.MyProfilePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

// Glowny Fragment odpowiadajacy za tab
class FavouriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_favourite, container, false)

        val tabLayout: TabLayout? = rootView.findViewById(R.id.tabLayoutMyFav)
        val viewPager: ViewPager2? = rootView.findViewById(R.id.viewPagerMyFav)

        if (tabLayout != null && viewPager != null) {
            val adapter = FavouriteViewPager(requireActivity())
            viewPager.adapter = adapter

            TabLayoutMediator(tabLayout, viewPager) { tab, position ->
                when (position) {
                    0 -> tab.text = "cards"
                    1 -> tab.text = "card set"
                }
            }.attach()
        }



        return rootView
    }
}
