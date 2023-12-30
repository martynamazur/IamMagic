package com.example.immagic.nawigation.dailyreward

import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class DailyRewardDialog(private val context: Context) {

    private lateinit var closeDialogBtn: ImageButton
    private lateinit var specialWeekReward: Button
    private lateinit var watchAddDoubleReward: Button
    private lateinit var claimReward: Button
    private lateinit var dailyRewardRc: RecyclerView


    fun showDialog() {
        val builder = AlertDialog.Builder(context)
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.daily_reward_dialog, null)

        closeDialogBtn = view.findViewById(R.id.closeDialogBtn)
        specialWeekReward = view.findViewById(R.id.specialWeekReward)
        watchAddDoubleReward = view.findViewById(R.id.watchAddDoubleReward)
        claimReward = view.findViewById(R.id.claimReward)
        dailyRewardRc = view.findViewById(R.id.dailyRewardRc)




        builder.setView(view)

        val dialog = builder.create()

        closeDialogBtn.setOnClickListener {
            dialog.dismiss()
        }

        claimReward.setOnClickListener {
            // zmienic streak update
            // dodaj do inwentarza update
        }

        watchAddDoubleReward.setOnClickListener {
            // zmienic streak update
            // dodaj do inwentarza update
        }

        dialog.show()
    }
}
