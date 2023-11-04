package com.example.immagic.first_use.setLanguage

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.CheckedTextView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.immagic.R

class LanguageAdapter(
    private val context: Context,
    private val languageList: ArrayList<LanguageModel>) :
    RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {

    private var lastCheckedPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.language_item, parent, false)
        return LanguageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return languageList.size
    }

    @SuppressLint("DiscouragedApi")
    override fun onBindViewHolder(holder: LanguageViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val languageModel = languageList[position]
        holder.languageCheckbox.text = languageModel.languageName
        val resId = context.resources.getIdentifier(languageModel.imagePath, "drawable", context.packageName)
        holder.flagIcon.setImageResource(resId)


        holder.languageCheckbox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                if (lastCheckedPosition != -1 && lastCheckedPosition != position) {
                    // Uncheck the previously checked item
                    languageList[lastCheckedPosition].isChecked = false
                    notifyItemChanged(lastCheckedPosition)
                }
                // Update the last checked position
                lastCheckedPosition = position
            }
            languageModel.isChecked = isChecked
        }

        // Set the checked state based on the model
        holder.languageCheckbox.isChecked = languageModel.isChecked


    }

    fun getSelectedLanguage(): String? {
        for (languageModel in languageList) {
            if (languageModel.isChecked) {
                return languageModel.languageNameShort
            }
        }
        return null // Nie znaleziono zaznaczonego języka
    }


    inner class LanguageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val languageCheckbox: CheckBox = itemView.findViewById(R.id.languageCheckboxFT)
        val flagIcon: ImageView = itemView.findViewById(R.id.flagIcon)
    }
}
