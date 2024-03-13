package com.example.immagic.nawigation.categories.category.categoryselection

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.homepage.HalfScreenBottomSheetDialogFragment
import com.example.immagic.homepage.Play.QuoteModel
import com.example.immagic.nawigation.categories.category.CategoryViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CategoryOverView: AppCompatActivity() {

    private var cardSetId: Int = -1

    private lateinit var readCardSetBtn: Button
    private lateinit var setNotificationBtn: Button
    private lateinit var likeCardSetBtn: ImageButton

    private lateinit var subcategoryOverViewGoBackBtn: ImageButton
    private lateinit var quotesRc: RecyclerView
    private lateinit var quoteList: List<QuoteModel>

    private lateinit var amountOfCard: TextView
    private lateinit var status: TextView


    private val categoryViewModel: CategoryViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_over_view_layout)

        // na tej podstawie wyswietlam odpowiednie karty, zestaw
        cardSetId = intent.getIntExtra("cardSetId",-1)
        Log.d("tag","wartosc $cardSetId")

        amountOfCard = findViewById(R.id.amountOfCards)
        status = findViewById(R.id.activityStatus)

        readCardSetBtn = findViewById(R.id.readCardSetBtn)
        setNotificationBtn = findViewById(R.id.setNotificationBtn)
        quotesRc = findViewById(R.id.quotesRc)
        likeCardSetBtn = findViewById(R.id.likeCardSetBtn)
        //subcategoryOverViewGoBackBtn = findViewById(R.id.subcategoryOverViewGoBackBtn)


        readCardSetBtn.setOnClickListener {

            //otworz dialog
            val bottomSheetFragment = HalfScreenBottomSheetDialogFragment(cardSetId)
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)

        }

        setNotificationBtn.setOnClickListener {
            //okienko ustawienia
            // po nim przechodze do fragmentu powiadomienia
        }
    }

}
