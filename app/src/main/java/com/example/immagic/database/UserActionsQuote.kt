package com.example.immagic.database

import androidx.room.*

@Entity(tableName = "UserActionsQuote",

        foreignKeys = [
            ForeignKey(
                entity = Quote::class,
                parentColumns = ["quoteId"],
                childColumns = ["quoteId"],
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE,

            ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["userId"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
        ]
    )
data class UserActionsQuote(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "userId") val idUser: Int,
    @ColumnInfo(name = "quoteId") val quoteId: Int,
    @ColumnInfo(name = "userSoundRecordFileName") val userSoundRecordFileName: String,
    @ColumnInfo(name = "userSoundStatus") val userSoundStatus: Boolean,
    @ColumnInfo(name = "favouriteStatus") val favouriteStatus: Int

   //Select quote_id.Quote, quote_content.Quote from Quote inner join UserActionsQuote on quote_id.UserActionQUote = quote_id.Quote where id_user = nazwaZmiennej;
)
