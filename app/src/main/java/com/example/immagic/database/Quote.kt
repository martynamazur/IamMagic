package com.example.bottomsheettest.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(tableName = "Quote")
data class Quote(
    @PrimaryKey @ColumnInfo(name = "quoteId") val quoteId: Int,
    @ColumnInfo(name = "quoteContent") val quoteContent: String,
    @ColumnInfo(name = "cardSetId") val cardSetId: Int,
    @ColumnInfo(name = "defaultFileRecordName") val defaultFileRecordName: String
)
