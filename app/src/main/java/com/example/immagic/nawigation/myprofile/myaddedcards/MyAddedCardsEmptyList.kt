package com.example.immagic.nawigation.myprofile.myaddedcards

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.EditText
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.immagic.R
import com.example.immagic.createquote.CreateNewQuoteModel
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.UserCreatedQuotes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MyAddedCardsEmptyList : Fragment() {

    private lateinit var addANewcard : Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.my_added_cards_empty, container, false)
        addANewcard = view.findViewById(R.id.addANewcard)

        addANewcard.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.dialog_add_new_card_layout)

            val quotesInput = dialog.findViewById<EditText>(R.id.quotesInput).text.toString()
            val saveNewCard = dialog.findViewById<Button>(R.id.saveNewCard)
            saveNewCard.setOnClickListener {

                //zapisz do bazy danych
                lifecycleScope.launch {
                    withContext(Dispatchers.IO){
                        val applicationContext = requireContext().applicationContext
                        val db = AppDatabase.getInstance(applicationContext)
                        //val createdQuote =  CreateNewQuoteModel(quotesInput)
                        val newQuote = UserCreatedQuotes(id_user = 1, quote = "Nowy cytujacy cytat")
                        db.userCreatedQuotes().addNewQuote(newQuote)
                        // Tworzenie nowego obiektu UserCreatedQuotes
                        dialog.dismiss()


                    }
                }

            }

            // Pokaż dialog na środku ekranu
            val window = dialog.window
            window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            window?.setGravity(Gravity.CENTER)
            dialog.show()

        }
        return view
    }

}
