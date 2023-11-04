package com.example.immagic.nawigation.favourite.cardset


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.immagic.R

class FavCardSetFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fav_card_set, container, false)


        val transaction = childFragmentManager.beginTransaction()
        val fragment = EmptyCardSetFragment()
        val fragment2 = ListFavCardSetFragment()
        val testCzyPustaLista = false

        if (testCzyPustaLista) {
            transaction.replace(R.id.fragmentContainerSet, fragment)
        } else {
            transaction.replace(R.id.fragmentContainerSet, fragment2)
        }

        transaction.addToBackStack(null)
        transaction.commit()


        return view
    }
}

