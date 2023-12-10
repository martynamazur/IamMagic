package com.example.immagic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.immagic.database.interfaceDao.*

@Database(
    entities = [User::class,
        Quote::class,
        UserActionsQuote::class,
        CourseCardSet::class,
        Course::class,
        Chapter::class,
        Category::class,
        Level::class,
        CategoryCardSet::class,
        Subcategory::class,
        Shop::class,
        NotificationDay::class,
        UserCreatedNotifications::class,
        UserCreatedQuotes::class,
        TreasureChest::class,
        ChestReward::class,
        Rewards::class,
        UserEquipment::class,

               ],

    version = 1, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): userDao
    abstract fun userActionsQuotesDao(): userActionsQuotesDao
    abstract fun courseDao(): courseDao
    abstract fun userCreatedQuotes(): userCreatedQuotes
    abstract fun treasureChest(): TreasureChestDao
    abstract fun userEquimpment(): UserEquimpmentDao
    abstract fun category(): CategoryDao
    //abstract fun loginHistory(): LoginHistory


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
