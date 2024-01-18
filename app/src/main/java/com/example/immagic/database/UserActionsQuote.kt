package com.example.immagic.database

import androidx.room.*
import com.example.bottomsheettest.database.Quote

@Entity(tableName = "UserActionsQuote")
data class UserActionsQuote(

    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long,
    //@ColumnInfo(name = "userId") val idUser: Int,
    @ColumnInfo(name = "quoteId") val quoteId: Int,
    @ColumnInfo(name = "userSoundRecordFileName") val userSoundRecordFileName: String,
    @ColumnInfo(name = "userSoundStatus") val userSoundStatus: Int,
    @ColumnInfo(name = "favouriteStatus") val favouriteStatus: Int,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int

)
