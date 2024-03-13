package com.example.immagic.nawigation.favourite.cardset

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFavCardSetFragment : Fragment() {

    private val favouriteViewModel: FavouriteViewModel by viewModel()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_fav_cardset, container,false)

        val cardSetListRc: RecyclerView = view.findViewById(R.id.cardSetListRc)
        cardSetListRc.layoutManager = GridLayoutManager(context,2)
        val favouriteCardSet = FavouriteCardSetAdapter(emptyList())
        cardSetListRc.adapter = favouriteCardSet

        favouriteViewModel.favouriteCardSetList.observe(viewLifecycleOwner){newFavouriteCardSetList ->
            favouriteCardSet.updateCardSetList(newFavouriteCardSetList)
        }
        return view
    }

}
