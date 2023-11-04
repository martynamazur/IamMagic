package com.example.immagic.database




import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey


@Entity(tableName = "Quote",
    foreignKeys = [
        ForeignKey(entity = CourseCardSet::class,
            parentColumns = ["id_cardSet"],
            childColumns = ["carSetId"])
    ]
)


data class Quote(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "quote_id") val quoteId: Int,
    @ColumnInfo(name = "quoteContent") val quoteContent: String,
    @ColumnInfo(name = "defaultFileRecordName") val defaultFileRecordName: String,
    @ColumnInfo(name = "set_id") val setId: Int,
    @ColumnInfo(name = "carSetId") val carSetId: Int
)


