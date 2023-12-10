package com.example.immagic.database.interfaceDao

import androidx.room.Dao
import androidx.room.Query

@Dao
interface LevelDao {

    @Query("SELECT required_points FROM Level where id_level := level ")
    suspend fun getRequiredPointsToLevelUp(level: Int):Int

    @Query("SELECT alchemy_points FROM Level where id_level := level ")
    suspend fun getAlchemyPointsPrize(level: Int): Int

    @Query("SELECT unlocked_category_id FROM Level where id_level := level")
    suspend fun getUnlockedCategoryPrize(level: Int): Int
}