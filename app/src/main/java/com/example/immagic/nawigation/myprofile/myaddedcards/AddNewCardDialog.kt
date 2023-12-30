package com.example.immagic.nawigation.myprofile.myaddedcards

import android.app.Dialog
import android.content.Context
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.lifecycleScope
import com.example.immagic.R
import com.example.immagic.database.AppDatabase
import com.example.immagic.database.UserCreatedQuotes
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AddNewCardDialog(
    context: Context,
    private val userId: Int,
    private val coroutineScope: CoroutineScope,
    private val onCardAdded: () -> Unit
) {

    private val dialog: Dialog = Dialog(context)

    init {
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setContentView(R.layout.dialog_add_new_card_layout)

        val quotesInput = dialog.findViewById<EditText>(R.id.quotesInput)
        val saveNewCard = dialog.findViewById<Button>(R.id.saveNewCard)

        saveNewCard.setOnClickListener {
            coroutineScope.launch {
                saveQuoteToDatabase(quotesInput.text.toString())
                dialog.dismiss()

                // Wywołaj funkcję onCardAdded po dodaniu nowej karty
                onCardAdded()
            }
        }
    }

    private suspend fun saveQuoteToDatabase(quoteContent: String) {
        withContext(Dispatchers.IO) {
            val applicationContext = dialog.context.applicationContext
            val db = AppDatabase.getInstance(applicationContext)
            val newQuote = UserCreatedQuotes( quote = quoteContent)
            db.userCreatedQuotes().addNewQuote(newQuote)
        }
    }

    fun show() {
        // Pokaż dialog na środku ekranu
        val window = dialog.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        window?.setGravity(Gravity.CENTER)
        dialog.show()
    }
}
