package com.example.immagic.nawigation.favourite.cardset


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavCardSetFragment : Fragment() {
    private val favouriteViewModel: FavouriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_fav_card_set, container, false)

        val transaction = childFragmentManager.beginTransaction()

        favouriteViewModel.getTotalNumberOfFavCardSet.observe(viewLifecycleOwner) { totalNumberOfFavCardSet ->
            if (totalNumberOfFavCardSet == 0) {
                transaction.replace(R.id.fragmentContainerSet, EmptyCardSetFragment())
            } else {
                transaction.replace(R.id.fragmentContainerSet, ListFavCardSetFragment())
            }

            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}


