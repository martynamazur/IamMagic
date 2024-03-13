package com.example.immagic.homepage

import android.content.Intent
import com.example.immagic.R


import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.widget.SwitchCompat
import com.example.immagic.homepage.Play.QuoteActivity
import com.example.immagic.homepage.Play.QuoteSettingsModel

class HalfScreenBottomSheetDialogFragment(private val cardSetId: Int) : BottomSheetDialogFragment() {

    private lateinit var playCardsBtn: Button
    private lateinit var voiceAssistantSwitch: SwitchCompat
    private lateinit var showTimerSwitch: SwitchCompat
    private lateinit var readOutLoudSwitch: SwitchCompat


    private var repeatSetCounter = 0

    private lateinit var repeatSetMinus: ImageButton
    private lateinit var repeatSetPlus: ImageButton
    private lateinit var repeatSetNumber: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.before_play, container, false)

        playCardsBtn = view.findViewById(R.id.playCardsBtn)

        voiceAssistantSwitch = view.findViewById(R.id.voiceAssistantSwitch)
        showTimerSwitch = view.findViewById(R.id.showTimerSwitch)
        readOutLoudSwitch = view.findViewById(R.id.readOutLoudSwitch)

        repeatSetPlus = view.findViewById(R.id.repeatSetPlus)
        repeatSetMinus = view.findViewById(R.id.repeatSetMinus)
        repeatSetNumber = view.findViewById(R.id.repeatSetNumber)


        repeatSetMinus.setOnClickListener {
            if (repeatSetCounter !=0){
                repeatSetCounter--
                repeatSetNumber.text = repeatSetCounter.toString()
            }
        }

        repeatSetPlus.setOnClickListener {
            repeatSetCounter++
            repeatSetNumber.text = repeatSetCounter.toString()
        }

        playCardsBtn.setOnClickListener {
            val myList = ArrayList<QuoteSettingsModel>()
            myList.add(QuoteSettingsModel(repeatSetCounter,voiceAssistantSwitch.isActivated, showTimerSwitch.isActivated,readOutLoudSwitch.isActivated ))

            val intent = Intent(requireContext(), QuoteActivity::class.java)
            intent.putExtra("cardSetId",cardSetId)
            intent.putParcelableArrayListExtra("quoteSettings", myList)
            startActivity(intent)
        }
        return view
    }
}
