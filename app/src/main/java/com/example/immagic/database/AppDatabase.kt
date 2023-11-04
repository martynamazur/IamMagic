package com.example.immagic.database

import com.example.immagic.database.Course
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.immagic.database.interfaceDao.courseDao
import com.example.immagic.database.interfaceDao.userActionsQuotesDao
import com.example.immagic.database.interfaceDao.userDao


@Database(entities = [User::class, Quote::class, UserActionsQuote::class, CourseCardSet::class, Course::class, Chapter::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): userDao
    abstract fun userActionsQuotesDao(): userActionsQuotesDao
    abstract fun courseDao(): courseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mydatabase"// Tutaj zmień na nazwę bazy danych w zależności od potrzeb
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
