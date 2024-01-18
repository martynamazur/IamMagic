package com.example.immagic.nawigation.categories.category.categoryselection

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R
import com.example.immagic.homepage.HalfScreenBottomSheetDialogFragment
import com.example.immagic.homepage.Play.QuoteModel

class CategoryOverView: AppCompatActivity() {

    private lateinit var readCardSetBtn: Button
    private lateinit var setNotificationBtn: Button
    private lateinit var likeCardSetBtn: ImageButton

    private lateinit var subcategoryOverViewGoBackBtn: ImageButton
    private lateinit var quotesRc: RecyclerView
    private lateinit var quoteList: List<QuoteModel>

    private var cardSetId =  intent.getStringExtra("cardSetId")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.category_over_view_layout)


        readCardSetBtn = findViewById(R.id.readCardSetBtn)
        setNotificationBtn = findViewById(R.id.setNotificationBtn)
        quotesRc = findViewById(R.id.quotesRc)
        likeCardSetBtn = findViewById(R.id.likeCardSetBtn)
        subcategoryOverViewGoBackBtn = findViewById(R.id.subcategoryOverViewGoBackBtn)

        subcategoryOverViewGoBackBtn.setOnClickListener {
            finish()
        }


        readCardSetBtn.setOnClickListener {
            //otworz dialog
            val bottomSheetFragment = HalfScreenBottomSheetDialogFragment(cardSetId)
            bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)

        }
    }

}
