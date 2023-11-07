package com.example.immagic.database

import com.example.immagic.database.Course
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.immagic.database.interfaceDao.courseDao
import com.example.immagic.database.interfaceDao.userActionsQuotesDao
import com.example.immagic.database.interfaceDao.userDao

@Database(entities = [User::class, Quote::class, UserActionsQuote::class, CourseCardSet::class, Course::class, Chapter::class, LoginHistory::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): userDao
    abstract fun userActionsQuotesDao(): userActionsQuotesDao
    abstract fun courseDao(): courseDao
    abstract fun loginHistory(): LoginHistory

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migracja z wersji 1 do 2
                // Wykonaj zmiany w bazie danych, np. ALTER TABLE, itp.
            }
        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migracja z wersji 2 do 3
                // Wykonaj inne zmiany w bazie danych
            }
        }

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "mydatabase"
                ).addMigrations(MIGRATION_1_2).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
