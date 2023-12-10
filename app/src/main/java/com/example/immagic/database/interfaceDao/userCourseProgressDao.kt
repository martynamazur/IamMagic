package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query
import com.example.immagic.help.PreferenceHelper

@Dao
interface userCourseProgressDao {

    @Query("UPDATE UserCourseProgress SET level =: newLevel AND idCardSet =:id_card_set AND id_user =:idUser")
    suspend fun updateCurrentLevel(newLevel: Int, idCardSet: Int, idUser : Int = PreferenceHelper.getCurrentUserId())

    @Query("UPDATE UserCourseProgress SET level_up_points =: newPoints AND idCardSet =:id_card_set AND id_user =:idUser")
    suspend fun updateLevelUpPoints( newPoints: Int, idCardSet: Int, idUser : Int = PreferenceHelper.getCurrentUserId())

    @Query("UPDATE UserCourseProgress is_ever_attendend =: newValue AND idCardSet =:id_card_set AND id_user =:idUser")
    suspend fun updateAttendaceStatus(newValue: Int,idCardSet: Int, idUser : Int = PreferenceHelper.getCurrentUserId())



}