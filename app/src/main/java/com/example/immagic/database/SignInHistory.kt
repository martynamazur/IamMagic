package com.example.immagic.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo

@Entity(tableName = "SignInHistory")
data class SignInHistory(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_login") val idLogin: Int,
    @ColumnInfo(name = "id_user") val idUser: Int,
    @ColumnInfo(name = "signin_datetime") val signinDatetime: String
)
