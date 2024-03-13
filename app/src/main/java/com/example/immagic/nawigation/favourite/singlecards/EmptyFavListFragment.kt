package com.example.immagic.nawigation.favourite.singlecards

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.categories.category.CategoryFragment

class EmptyFavListFragment : Fragment() {

    private lateinit var exploreBtn: Button
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.empty_fav_cards_layout, container, false)

        exploreBtn = view.findViewById(R.id.exploreBtn)

        exploreBtn.setOnClickListener {
            val categoryFragment = CategoryFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, categoryFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }


        return view

    }
}
