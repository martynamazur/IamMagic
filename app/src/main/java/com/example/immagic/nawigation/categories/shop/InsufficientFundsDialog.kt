package com.example.immagic.nawigation.categories.shop

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.immagic.R

class InsufficientFundsDialog(context: Context) : Dialog(context) {

    private lateinit var closeButton: Button
    private lateinit var messageTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_insufficient_funds)

        closeButton = findViewById(R.id.closeButton)
        messageTextView = findViewById(R.id.messageTextView)

        closeButton.setOnClickListener {
            dismiss()
        }
    }

}
