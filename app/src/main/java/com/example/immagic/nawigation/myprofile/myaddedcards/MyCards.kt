package com.example.immagic.nawigation.myprofile.myaddedcards

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R
import com.example.immagic.nawigation.myprofile.myaddedcards.createcard.EmptyMyCards
import com.example.immagic.nawigation.myprofile.myaddedcards.createcard.ListMyCards

class MyCards: AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_cards)


        val transaction = supportFragmentManager.beginTransaction()
        val fragment = EmptyMyCards()
        val fragment2 = ListMyCards()
        val testCzyPustaLista = true

        if (testCzyPustaLista) {
            transaction.replace(R.id.myCardsFrame, fragment)
        } else {
            transaction.replace(R.id.myCardsFrame, fragment2)
        }

        transaction.addToBackStack(null)
        transaction.commit()

    }

}
