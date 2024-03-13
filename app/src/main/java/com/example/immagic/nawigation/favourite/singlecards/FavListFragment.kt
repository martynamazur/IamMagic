package com.example.immagic.nawigation.favourite.singlecards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.FavouriteCardsModel
import com.example.immagic.nawigation.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavListFragment : Fragment(), UnlikeQuoteListener {

    private val favouriteViewModel: FavouriteViewModel by viewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.list_fav_cards_layout, container, false)


        val favouriteCardsRecycler: RecyclerView = view.findViewById(R.id.favCardsRc)
        favouriteCardsRecycler.layoutManager = LinearLayoutManager(context)

        val favouriteCardsAdapter = FavouriteCardsAdapter(emptyList(), this)
        favouriteCardsRecycler.adapter = favouriteCardsAdapter


        favouriteViewModel.favouriteCards.observe(viewLifecycleOwner) { favouriteCards ->
            favouriteCardsAdapter.updateData(favouriteCards)
        }

        return view
    }

    override fun deleteQuoteFromList(quoteId: Int) {
        favouriteViewModel.deleteQuoteFromList(quoteId)
    }
}
