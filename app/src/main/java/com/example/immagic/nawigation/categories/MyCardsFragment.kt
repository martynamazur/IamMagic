package com.example.immagic.nawigation.categories

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.immagic.R
import com.example.immagic.nawigation.categories.CategoryAdapter
import com.example.immagic.nawigation.categories.CategoryModel
import com.example.immagic.nawigation.myprofile.MyProfilePagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MyCardsFragment : Fragment() {

    private lateinit var categoriesRc: RecyclerView
    private lateinit var categoryList: ArrayList<CategoryModel>
    private lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_my_cards, container, false)

        // Initialize your list here
        //categoryList = ArrayList()

       // categoryAdapter = CategoryAdapter(this, requireContext(), categoryList)
        //categoriesRc = view.findViewById(R.id.categoriesRc)


        val tabLayout: TabLayout = view.findViewById(R.id.tabLayoutMyCards)
        val viewPager: ViewPager2 = view.findViewById(R.id.viewPagerMyCards)
        val adapter = CategoryPagerAdapter(requireActivity())
        viewPager.adapter = adapter



        TabLayoutMediator(tabLayout, viewPager) { tab, position ->

            when(position){
                0 -> tab.text = "Category"
                1 -> tab.text = "Shop"
            }

        }.attach()
        return view
    }


}
