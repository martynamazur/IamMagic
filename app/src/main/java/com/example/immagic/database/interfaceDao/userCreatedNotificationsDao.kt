package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import com.example.immagic.createnotification.NotificationModel

@Dao
interface userCreatedNotificationsDao {

    @Insert
    suspend fun setNewNotification( newNotification : NotificationModel)


    //edit notification quieries
}