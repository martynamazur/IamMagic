package com.example.immagic.first_use.setLanguage

data class LanguageModel(
    val languageNameShort: String,
    val languageName: String,
    val imagePath: String,
    var isChecked: Boolean = false) {
}