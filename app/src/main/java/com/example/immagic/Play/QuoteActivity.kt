package com.example.immagic.Play

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import androidx.core.graphics.drawable.toBitmap
import androidx.core.view.WindowCompat
import com.example.immagic.R
import com.example.immagic.homepage.ShareFileManager
import com.example.immagic.nawigation.ManageNawigation
import java.io.File
import java.io.FileOutputStream
import kotlin.properties.Delegates

class QuoteActivity : AppCompatActivity() {

    private val quotes = arrayOf(
        "com.example.immagic.database.Quote 1",
        "com.example.immagic.database.Quote 2",
        "com.example.immagic.database.Quote 3",
        "com.example.immagic.database.Quote hue",
        "com.example.immagic.database.Quote 4",
        "com.example.immagic.database.Quote 6",
        "Life is a journey that must be traveled no matter how bad the roads and accommodations.",
        "The only way to do great work is to love what you do.",
        "The greatest glory in living lies not in never falling, but in rising every time we fall.",
        "Life is really simple, but we insist on making it complicated.",
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "In the end, we will remember not the words of our enemies, but the silence of our friends."
    )// liste pobiore z bazy danych

    private var currentQuoteIndex = 0
    private lateinit var quoteTextView: TextView
    private lateinit var gestureDetector: GestureDetector
    private lateinit var progressBarReadCards: ProgressBar
    private var amountOfCardInSet by Delegates.notNull<Int>()
    private lateinit var amountOfReadCardsText : TextView

    //Variables to count points

    private var writedQuotes = 0
    private var playedSound = 0
    private var recorderSound = 0
    private var addedToFavourited = 0

    // Nawigation bottom
    private lateinit var playedSoundBtn: ImageButton
    private lateinit var recorderSoundBtn: ImageButton
    private lateinit var writedQuotesBtn: ImageButton
    private lateinit var addedToFavouritedBtn: ImageButton
    private lateinit var shareBtn: ImageButton

    //Close
    private lateinit var closeCourseBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)


        closeCourseBtn = findViewById(R.id.closeCourseBtn)

        playedSoundBtn = findViewById(R.id.playedSoundBtn)
        recorderSoundBtn = findViewById(R.id.recorderSoundBtn)
        writedQuotesBtn = findViewById(R.id.writedQuotesBtn)
        addedToFavouritedBtn = findViewById(R.id.likedBtn)
        shareBtn = findViewById(R.id.shareBtn)


        amountOfReadCardsText = findViewById(R.id.amountOfReadCards)
        progressBarReadCards = findViewById(R.id.progressBarCards)
        quoteTextView = findViewById(R.id.quoteTextView)
        gestureDetector = GestureDetector(this, MyGestureListener())

        //Cancel, exit
        closeCourseBtn.setOnClickListener {
            closeCourseBtn()
        }

        //Wyciagnac z bazy danych informacje o danym secie i na tej podsatwie uzupelnic
        // nie potzrebuje LiveData bo te inf sa stale, nei zmienne
        // Initialize with the first quote
        amountOfCardInSet = 12 -1

        progressBarReadCards.max = amountOfCardInSet

        //Update Ui
        updateQuoteText()
        updateTextAmount(0)


        addedToFavouritedBtn.setOnClickListener {
            //zmien w bazie danych
            //dodaj punkt
            //zmien stan ikony
            //spr,pobieram wartosc z bazy danych ?
            //chociaz dzialam na modelu ...liscie


        }

        shareBtn.setOnClickListener {
            // val generateQuotePicture = GenerateQuotePicture()
            //TODO przekazac wygenerowanyobraz, sciezke
            val shareFileManager = ShareFileManager(this)
            shareFileManager.shareFile()
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

                if (deltaY < 0 && currentQuoteIndex < quotes.size - 1) {
                    currentQuoteIndex++
                    progressBarReadCards.progress = currentQuoteIndex
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

    //TODO: przeniesc to do innego pliku
    fun closeCourseBtn(){
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setTitle(R.string.dialog_title)
        alertDialogBuilder.setMessage(R.string.dialog_message)

        alertDialogBuilder.setPositiveButton(R.string.dialog_quit_text){dialog, which ->
            val intent = Intent(this,ManageNawigation::class.java )
            startActivity(intent)
            finish()

    }
        alertDialogBuilder.setNegativeButton(R.string.dialog_stay_text){dialog, which ->
            dialog.dismiss()

    }

        val alertDialog = alertDialogBuilder.create()
        alertDialog.show()

}}
