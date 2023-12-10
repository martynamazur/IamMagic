package com.example.immagic.database.interfaceDao
import androidx.room.Dao
import androidx.room.Query

@Dao
interface createNotificationDao {

    @Query("INSERT INTO UserCreatedNotificationsBridge (id_user, id_notification) VALUES (:userId, (INSERT INTO UserCreatedNotifications (id_cardSet, status, time_start, time_start_indicator, time_end, time_end_indicator) VALUES (:id_cardSet, :status, :time_start, :time_start_indicator, :time_end, :time_end_indicator))")
    suspend fun addNewNotification(userId: Int, id_cardSet: Int, status: Boolean, time_start: String, time_start_indicator: String, time_end: String, time_end_indicator: String)

    @Query("UPDATE UserCreatedNotifications SET status = :newStatus WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun changeStatus(userId: Int, idNotification: Int, newStatus: Boolean)

    @Query("UPDATE UserCreatedNotifications SET time_start = :newTimeStart WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun updateTimeStart(userId: Int, idNotification: Int, newTimeStart: String)

    @Query("UPDATE UserCreatedNotifications SET time_end = :newTimeEnd WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun updateTimeEnd(userId: Int, idNotification: Int, newTimeEnd: String)

    @Query("UPDATE UserCreatedNotifications SET time_start_indicator = :newTimeStartIndicator WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun updateTimeStartIndicator(userId: Int, idNotification: Int, newTimeStartIndicator: String)

    @Query("UPDATE UserCreatedNotifications SET time_end_indicator = :newTimeEndIndicator WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun updateTimeEndIndicator(userId: Int, idNotification: Int, newTimeEndIndicator: String)

    @Query("DELETE FROM UserCreatedNotifications WHERE id_user = :userId AND id_notification = :idNotification")
    suspend fun deleteNotification(userId: Int, idNotification: Int)

}