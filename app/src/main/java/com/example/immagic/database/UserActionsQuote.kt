package com.example.immagic.database

import androidx.room.*

@Entity(tableName = "UserActionsQuote",

        foreignKeys = [
            ForeignKey(
                entity = Quote::class,
                parentColumns = ["quote_id"],
                childColumns = ["quote_id"],
                onDelete = ForeignKey.CASCADE,
                onUpdate = ForeignKey.CASCADE,

            ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id_user"],
            childColumns = ["id_user"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
        ]
    )
data class UserActionsQuote(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    @ColumnInfo(name = "id_user") val idUser: Int,
    @ColumnInfo(name = "quote_id") val quoteId: Int,
    @ColumnInfo(name = "user_recording_file_name") val userRecordingFileName: String,
    @ColumnInfo(name = "user_recording_status") val userRecordingStatus: Int,
    @ColumnInfo(name = "added_to_favourite_status") val addedToFavouriteStatus: Int

   //Select quote_id.Quote, quote_content.Quote from Quote inner join UserActionsQuote on quote_id.UserActionQUote = quote_id.Quote where id_user = nazwaZmiennej;
)
