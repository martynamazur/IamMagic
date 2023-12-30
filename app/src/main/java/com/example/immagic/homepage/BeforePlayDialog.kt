package com.example.immagic.homepage

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.Button
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.example.immagic.R
import com.google.android.material.bottomsheet.BottomSheetDialog

class BeforePlayDialog(private val context: Context) {

    private lateinit var closeButton: Button

    fun showDialog() {
        val bottomSheetDialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.before_play, null)
        bottomSheetDialog.setContentView(view)

        // Ustawienie parametrów okna
        val layoutParams = (view.parent as View).layoutParams as CoordinatorLayout.LayoutParams
        layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT


        bottomSheetDialog.show()
    }
}
