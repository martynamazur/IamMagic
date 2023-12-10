package com.example.immagic.nawigation.myprofile.myaddedcards

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ImageButton
import android.widget.PopupMenu
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.immagic.R
import com.example.immagic.createquote.CreateNewQuoteModel
import com.example.immagic.database.AppDatabase
import com.example.immagic.nawigation.myprofile.myaddedcards.notempty.MyAddedCardsNotEmptyList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyAddedCards: AppCompatActivity() {

    private lateinit var goBackNawigationBtn: ImageButton
    private lateinit var menuBtn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.my_added_cards)
        goBackNawigationBtn = findViewById(R.id.goBackNawigationBtnMyCards)
        menuBtn = findViewById(R.id.menuBtnMyCards)

        lifecycleScope.launch {
            getStateOfList()
        }


        goBackNawigationBtn.setOnClickListener {  finish() }

        menuBtn.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        popupMenu.inflate(R.menu.edit_menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.menu_delete_all -> {
                    true
                }
                R.id.menu_delete_selected -> {
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    private suspend fun getStateOfList() {
        try {
            withContext(Dispatchers.IO) {
                val applicationContext = this@MyAddedCards.applicationContext
                val db = AppDatabase.getInstance(applicationContext)

                // Pobierz listę rekordów z bazy danych
                val quotesList = db.userCreatedQuotes().getCreatedQuotes(1)

                // Przekaż listę do funkcji obsługującej stan
                handleListState(quotesList)
            }
        } catch (e: Exception) {
            // Tutaj obsługuj błąd (np. wypisz go do logów)
            e.printStackTrace()
        }
    }


    private fun handleListState(quotesList: List<CreateNewQuoteModel>) {

        val transaction = supportFragmentManager.beginTransaction()
        val fragmentEmptyList = MyAddedCardsEmptyList()
        val fragmentNotEmptyList = MyAddedCardsNotEmptyList()
        val isEmpty = quotesList.size

        if(isEmpty > 0){
            transaction.replace(R.id.fragmentContainerMyAddedCards, fragmentNotEmptyList)
        }else{
            transaction.replace(R.id.fragmentContainerMyAddedCards, fragmentEmptyList)
        }
        transaction.addToBackStack(null)
        transaction.commit()

    }


}
