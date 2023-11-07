package com.example.immagic.nawigation.myprofile

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.immagic.R

class EmptyMyCards: Fragment() {

    private lateinit var createCard: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_empty_my_cards, container, false)
        createCard = view.findViewById(R.id.createCard)

        createCard.setOnClickListener {
            val dialog = Dialog(requireContext())
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
            dialog.setCancelable(true)
            dialog.setContentView(R.layout.dialog_add_new_card_layout)

            /*
            // Wyszukaj elementy interfejsu w niestandardowym layoucie dialogu
            val closeButton = dialog.findViewById<ImageButton>(R.id.closeBtn)
            closeButton.setOnClickListener {
                dialog.dismiss()
            }
            */

            val saveNewCard = dialog.findViewById<Button>(R.id.saveNewCard)
            saveNewCard.setOnClickListener {
                //zapisz do bazy danych
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
