package com.example.immagic.Play

import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.immagic.R
import kotlin.properties.Delegates

class QuoteActivity : AppCompatActivity() {

    private val quotes = arrayOf(
        "Quote 1",
        "Quote 2",
        "Quote 3",
        "Quote hue",
        "Quote 4",
        "Quote 6",
        "Life is a journey that must be traveled no matter how bad the roads and accommodations.",
        "The only way to do great work is to love what you do.",
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "Life is really simple, but we insist on making it complicated.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "In the end, we will remember not the words of our enemies, but the silence of our friends."
    )

    private var currentQuoteIndex = 0
    private lateinit var quoteTextView: TextView
    private lateinit var gestureDetector: GestureDetector
    private lateinit var progressBarReadCards: ProgressBar
    private var amountOfCardInSet by Delegates.notNull<Int>()
    private lateinit var amountOfReadCardsText : TextView

    /*
    Variables to count points
     */

    private var writedQuotes = 0
    private var playedSound = 0
    private var recorderSound = 0
    private var addedToFavourited = 0

    // przyciski
    private lateinit var playedSoundBtn: ImageButton
    private lateinit var recorderSoundBtn: ImageButton
    private lateinit var writedQuotesBtn: ImageButton
    private lateinit var addedToFavouritedBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)

        System.out.println("jestem tutaj")

        playedSoundBtn = findViewById(R.id.playedSoundBtn)
        recorderSoundBtn = findViewById(R.id.recorderSoundBtn)
        writedQuotesBtn = findViewById(R.id.writedQuotesBtn)
        addedToFavouritedBtn = findViewById(R.id.likedBtn)


        amountOfReadCardsText = findViewById(R.id.amountOfReadCards)
        progressBarReadCards = findViewById(R.id.progressBarCards)
        quoteTextView = findViewById(R.id.quoteTextView)
        gestureDetector = GestureDetector(this, MyGestureListener())

        // Initialize with the first quote
        amountOfCardInSet = 12 -1
        progressBarReadCards.setProgress(amountOfCardInSet)// ustawic potem ze zmiennej po wyciagnieciu z bazy danych

        updateQuoteText()
        updateTextAmount(0)
        // baza danych : id, zawartosc, soundAsistant, soundMine

        //Wyciagnac z bazy danych informacje o danym secie


        addedToFavouritedBtn.setOnClickListener {
            //zmien w bazie danych
            //dodaj punkt
            //zmien stan ikony

        }


    }

    private fun updateQuoteText() {
        quoteTextView.text = quotes[currentQuoteIndex]
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if (event != null) {
            gestureDetector.onTouchEvent(event)
        }
        return super.onTouchEvent(event)
    }

    inner class MyGestureListener : GestureDetector.SimpleOnGestureListener() {
        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            if (e1 != null) {
                val deltaY = e2.y - e1.y


                // Swipe up (change direction)
                if (deltaY < 0 && currentQuoteIndex < quotes.size - 1) {
                    currentQuoteIndex++
                    progressBarReadCards.setProgress(currentQuoteIndex)
                    updateQuoteText()
                    updateTextAmount(currentQuoteIndex)
                 } else if (currentQuoteIndex == quotes.size - 1) {

                // Jesteś na końcu, przejdź do ekranu podsumowania
                startActivity(Intent(this@QuoteActivity, Summary::class.java))
                finish()
            }
            }
            return true
        }
    }
    fun updateTextAmount(currentQuoteIndex: Int){
        amountOfReadCardsText.setText("$currentQuoteIndex/$amountOfCardInSet")
    }


}
