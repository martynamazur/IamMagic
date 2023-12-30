package com.example.immagic.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Quote",
    foreignKeys = [
        ForeignKey(
            entity = CourseCardSet::class,
            parentColumns = ["cardSetId"],
            childColumns = ["carSetId"]
        )
    ]
)


data class Quote(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "quoteId") val quoteId: Int,
    @ColumnInfo(name = "quoteContent") val quoteContent: String,
    @ColumnInfo(name = "carSetId") val carSetId: Int,

    @ColumnInfo(name = "defaultFileRecordName") val defaultFileRecordName: String
)


