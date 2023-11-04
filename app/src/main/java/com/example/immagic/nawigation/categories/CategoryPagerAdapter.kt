package com.example.immagic.nawigation.categories

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class CategoryPagerAdapter( fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity){

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> CategoryFragment()
            1 -> ShopFragment()
            else -> CategoryFragment()
        }
    }

}
