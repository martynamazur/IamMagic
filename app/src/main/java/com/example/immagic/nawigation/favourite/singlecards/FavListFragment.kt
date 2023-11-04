package com.example.immagic.nawigation.favourite.singlecards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.favourite.singlecards.manage.LikedQuotesAdapter
import com.example.immagic.nawigation.favourite.singlecards.manage.LikedQuotesModel

class FavListFragment : Fragment() {

    private lateinit var favCardsRc: RecyclerView
    private lateinit var favCardsList: ArrayList<LikedQuotesModel>
    lateinit var favCardsAdapter: LikedQuotesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_fav_cards_layout, container, false)

        //getList()

        favCardsRc = view.findViewById(R.id.favCardsRc)
        favCardsList = ArrayList()
        favCardsAdapter = LikedQuotesAdapter(favCardsList)
        favCardsRc.layoutManager = LinearLayoutManager(requireContext())
        favCardsRc.adapter = favCardsAdapter

        return view
    }

    fun getList(){
        val database: AppDatabase = AppDatabase.getInstance(requireContext())
        val likedQuotes: List<LikedQuotesModel> = database.userActionsQuotesDao().getLikedQuotes(1)
        println("ile jest"+likedQuotes.size)
    }
}
