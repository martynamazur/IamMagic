package com.example.immagic.nawigation.myprofile.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.viewpager2.widget.ViewPager2
import com.example.immagic.R

import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyProfileFragment : Fragment() {

    companion object {
        fun newInstance(): MyProfileFragment {
            return MyProfileFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false)

        val tabLayout: TabLayout = view.findViewById(R.id.tabLayoutMyProfile)
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPagerMyProfile)


        val adapter = MyProfilePagerAdapter(requireActivity())
        viewPager.adapter = adapter


        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when(position){
                0 -> tab.text = "My profile"
                1 -> tab.text = "Settings"
            }

        }.attach()

        return view
    }


}
