package com.example.immagic.nawigation.favourite.singlecards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.singlecards.EmptyFavListFragment
import com.example.immagic.nawigation.favourite.singlecards.FavListFragment
//fragment wewnwtarz odp za wyswietlenie wlasciwego fragmentu (2 states)
class FavCardsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fav_cards, container, false)

        val transaction = childFragmentManager.beginTransaction()
        val fragment = EmptyFavListFragment()
        val fragment2 = FavListFragment()
        val testCzyPustaLista = true

        if (testCzyPustaLista) {
            transaction.replace(R.id.fragmentContainer, fragment)
        } else {
            transaction.replace(R.id.fragmentContainer, fragment2)
        }

        transaction.addToBackStack(null)
        transaction.commit()

        return view
    }
}
