package com.example.immagic.nawigation.myprofile.myaddedcards.notempty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.createquote.CreateNewQuoteModel
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.myprofile.myaddedcards.AddNewCardDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyAddedCardsNotEmptyList : Fragment() {

    private lateinit var myAddedCardsList: ArrayList<CreateNewQuoteModel>
    private lateinit var myAddedCardsRc: RecyclerView
    private lateinit var myAddedCardsAdapter: MyCardsListAdapter
    private lateinit var viewModel: MyAddedCardsViewModel
    private lateinit var addNewCardBtn: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_added_cards_not_empty, container, false)

        myAddedCardsList = ArrayList()
        myAddedCardsAdapter = MyCardsListAdapter(myAddedCardsList)
        myAddedCardsRc = view.findViewById(R.id.myAddedCardsRc)
        myAddedCardsRc.layoutManager = LinearLayoutManager(requireContext())
        myAddedCardsRc.adapter = myAddedCardsAdapter

        // Inicjalizacja ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(MyAddedCardsViewModel::class.java)

        // Obserwacja LiveData
        viewModel.quotesLiveData.observe(viewLifecycleOwner, Observer { updatedQuotesList ->
            myAddedCardsList.clear()
            myAddedCardsList.addAll(updatedQuotesList)
            myAddedCardsAdapter.notifyDataSetChanged()
        })

        initViews(view)

        return view
    }

    private fun initViews(view: View) {
        // Inicjalizacja widoków
        addNewCardBtn = view.findViewById(R.id.addNewCardBtn)

        // Inicjalizacja ViewModel
        viewModel = ViewModelProvider(requireActivity()).get(MyAddedCardsViewModel::class.java)

        // Obserwacja LiveData
        viewModel.quotesLiveData.observe(viewLifecycleOwner, Observer { updatedQuotesList ->
            myAddedCardsList.clear()
            myAddedCardsList.addAll(updatedQuotesList)
            myAddedCardsAdapter.notifyDataSetChanged()
        })

        // Pobierz dane po utworzeniu widoku
        lifecycleScope.launch {
            getAllMyCards()
        }

        addNewCardBtn.setOnClickListener {

            val addNewCardDialog = AddNewCardDialog(requireContext(), 1, lifecycleScope) {
                // Po dodaniu nowej karty wywołaj funkcję ponownie, aby zaktualizować listę
                lifecycleScope.launch {
                    getAllMyCards()
                }
            }
            addNewCardDialog.show()
        }
    }

    private suspend fun getAllMyCards() {
        lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                val applicationContext = requireContext().applicationContext
                val db = AppDatabase.getInstance(applicationContext)
                val quotesList = db.userCreatedQuotes().getCreatedQuotes()

                // Aktualizuj LiveData w ViewModel
                viewModel.updateQuotesList(quotesList)
            }
        }
    }
}
