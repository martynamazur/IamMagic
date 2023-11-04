package com.example.immagic.nawigation.favourite

import com.example.immagic.nawigation.favourite.cardset.FavCardSetFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.immagic.nawigation.favourite.singlecards.FavCardsFragment


class FavouriteViewPager(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {


        return when(position){
            0 -> FavCardsFragment()
            1 -> FavCardSetFragment()
            else -> FavCardsFragment()
        }
    }
}
