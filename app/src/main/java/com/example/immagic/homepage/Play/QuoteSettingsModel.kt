package com.example.immagic.homepage.Play

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class QuoteSettingsModel(
    val repeatSetCounter: Int,
    val voiceAssistant: Boolean,
    val showTimer: Boolean,
    val readOutLoud: Boolean
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte(),
        parcel.readByte() != 0.toByte()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(repeatSetCounter)
        parcel.writeByte(if (voiceAssistant) 1 else 0)
        parcel.writeByte(if (showTimer) 1 else 0)
        parcel.writeByte(if (readOutLoud) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<QuoteSettingsModel> {
        override fun createFromParcel(parcel: Parcel): QuoteSettingsModel {
            return QuoteSettingsModel(parcel)
        }

        override fun newArray(size: Int): Array<QuoteSettingsModel?> {
            return arrayOfNulls(size)
        }
    }
}