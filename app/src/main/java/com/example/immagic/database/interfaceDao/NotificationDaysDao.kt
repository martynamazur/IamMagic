package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.immagic.database.NotificationDaysModel

@Dao
interface NotificationDaysDao {

    @Insert
    suspend fun addNotificationDays( notificationDayInformation: NotificationDaysModel)

    @Query("DELETE FROM NotificationDays where id_notification =: id_notification")
    suspend fun deleteNotification(id_notification: Int)


    //edycja
    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDaySunday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDayMonday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDayTuesday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDayWednesday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDayThursday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDayFriday(id_notification: Int, value: Int )

    @Query("Update NotificationDays Set Sunday := value where id_notification =:id_notification")
    suspend fun updateDaySaturday(id_notification: Int, value: Int )
}