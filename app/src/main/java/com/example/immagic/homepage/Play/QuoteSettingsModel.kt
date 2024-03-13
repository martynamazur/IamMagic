package com.example.immagic.homepage.Play

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

import java.io.Serializable
@Parcelize
data class QuoteSettingsModel(
    val repeatSetCounter: Int,
    val voiceAssistant: Boolean,
    val showTimer: Boolean,
    val readOutLoud: Boolean
): Parcelable
