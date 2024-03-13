package com.example.immagic.homepage.Play

import android.content.Intent
import android.os.Build.VERSION
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.IntentCompat
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager.widget.ViewPager
import com.example.immagic.R
import com.example.immagic.homepage.ShareFileManager
import com.example.immagic.nawigation.ManageNawigation
import com.example.immagic.nawigation.categories.category.CategoryAdapter
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class QuoteActivity : AppCompatActivity() {

    private var currentQuoteIndex = 0
    private lateinit var quoteTextView: TextView
    private lateinit var gestureDetector: GestureDetector
    private lateinit var progressBarReadCards: ProgressBar
    private var amountOfCardInSet = 0
    private lateinit var amountOfReadCardsText: TextView

    // Nawigation bottom
    private lateinit var playedSoundBtn: ImageButton
    private lateinit var recorderSoundBtn: ImageButton
    private lateinit var writedQuotesBtn: ImageButton
    private lateinit var addedToFavouritedBtn: ImageButton
    private lateinit var shareBtn: ImageButton
    private lateinit var closeCourseBtn: ImageButton

    private lateinit var swipeGestureListener: SwipeGestureListener
    private lateinit var quoteList: List<QuoteModel>
    private lateinit var userActivity: List<QuoteActivityModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        val cardSetId = intent.getIntExtra("cardSetId",-1)
        val myList: ArrayList<QuoteSettingsModel>? = IntentCompat.getParcelableArrayListExtra(intent, "quoteSettings", QuoteSettingsModel::class.java)
        Log.d("tag","wartosi ${myList!!.get(0).readOutLoud}")

        val playQuoteViewModel: PlayQuoteViewModel by viewModel { parametersOf(cardSetId) }

        TODO("Odkomentowac, kiedy uzupelnie baze danych . Dodac cytaty do zestawu bo nie mam na czym testowac")

        swipeGestureListener = SwipeGestureListener {
            handleSwipe()
        }

        gestureDetector = GestureDetector(this, swipeGestureListener)


        val rep: PlayQuoteRepository = PlayQuoteImp(this )
        quoteList = emptyList()


        lifecycleScope.launch {
            quoteList = rep.getAllQuotes(cardSetId)
            Log.d("tag","ile jest w liscie ${quoteList.size}")
            amountOfCardInSet = quoteList.size
            updateQuoteText()
            updateTextAmount(0)
        }




        //playQuoteViewModel.quoteList.observe(this, { quotes -> quoteList = quotes})

        Log.d("tag","ile jest w liscie ${quoteList.size}")



        closeCourseBtn = findViewById(R.id.closeCourseBtn)
        playedSoundBtn = findViewById(R.id.playedSoundBtn)
        recorderSoundBtn = findViewById(R.id.recorderSoundBtn)
        writedQuotesBtn = findViewById(R.id.writedQuotesBtn)
        addedToFavouritedBtn = findViewById(R.id.likedBtn)
        shareBtn = findViewById(R.id.shareBtn)
        amountOfReadCardsText = findViewById(R.id.amountOfReadCards)
        progressBarReadCards = findViewById(R.id.progressBarCards)
        quoteTextView = findViewById(R.id.quoteTextView)

        closeCourseBtn.setOnClickListener { closeCourseBtn()}

        amountOfCardInSet = quoteList.size
        progressBarReadCards.max = amountOfCardInSet


        addedToFavouritedBtn.setOnClickListener {

        }

        shareBtn.setOnClickListener {
            val shareFileManager = ShareFileManager(this)
            shareFileManager.shareFile()
        }
    }

    private fun handleSwipe() {
        if (currentQuoteIndex < quoteList.size - 1) {
            currentQuoteIndex++
            progressBarReadCards.progress = currentQuoteIndex
            updateQuoteText()
            updateTextAmount(currentQuoteIndex)
        } else {
            // Jesteś na końcu, przejdź do ekranu podsumowania
            //przekaz obiekt typu RewardManager
            //val playReward = RewardSystemManager(received)
            startActivity(Intent(this@QuoteActivity, Summary::class.java))
            finish()
        }
    }
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            return gestureDetector.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }



    private fun updateQuoteText() {
        quoteTextView.text = quoteList[currentQuoteIndex].quoteContent
    }


    private fun updateTextAmount(currentQuoteIndex: Int) {
        amountOfReadCardsText.text = "$currentQuoteIndex/$amountOfCardInSet"
    }

    fun closeCourseBtn() {
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(R.string.dialog_title)
        alertDialogBuilder.setMessage(R.string.dialog_message)

        alertDialogBuilder.setPositiveButton(R.string.dialog_quit_text) { dialog, which ->
            val intent = Intent(this, ManageNawigation::class.java)
            startActivity(intent)
            finish()
        }
        alertDialogBuilder.setNegativeButton(R.string.dialog_stay_text) { dialog, which ->
            dialog.dismiss()
        }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

    }



}


