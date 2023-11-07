package com.example.immagic.nawigation.myprofile

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.immagic.R
import com.example.immagic.nawigation.favourite.cardset.EmptyCardSetFragment
import com.example.immagic.nawigation.favourite.cardset.ListFavCardSetFragment

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
