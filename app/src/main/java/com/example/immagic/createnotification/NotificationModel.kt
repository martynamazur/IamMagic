package com.example.immagic.createnotification

data class NotificationModel(
    val activeStatus: Boolean,
    val timeStart: String,
    val timeEnd: String,
    val timeStartIndicator: String,
    val timeEndIndicator: String,

)