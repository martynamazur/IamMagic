package com.example.immagic.nawigation.favourite.singlecards

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.FavouriteViewModel
import com.example.immagic.nawigation.favourite.cardset.EmptyCardSetFragment
import com.example.immagic.nawigation.favourite.cardset.ListFavCardSetFragment

import org.koin.androidx.viewmodel.ext.android.viewModel


class FavCardsFragment : Fragment() {

    private val favouriteViewModel: FavouriteViewModel by viewModel()



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fav_cards, container, false)



        val transaction = childFragmentManager.beginTransaction()

        favouriteViewModel.getTotalNumberOfFavouriteCards.observe(viewLifecycleOwner) { totalNumberOfFavouriteCards ->
            Log.d("xd", "tutaj: $totalNumberOfFavouriteCards")

            if (totalNumberOfFavouriteCards == 0) {
                Log.d("s","dopra empty card powinno sie uruchominc")
                transaction.replace(R.id.fragmentContainer, EmptyFavListFragment())
            } else {
                Log.d("s","lista z cytatami przechodzi")
                transaction.replace(R.id.fragmentContainer, FavListFragment())
            }

            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}
