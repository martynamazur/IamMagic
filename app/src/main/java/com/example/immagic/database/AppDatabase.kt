package com.example.immagic.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.bottomsheettest.database.*
import com.example.bottomsheettest.database.interf.*
import com.example.immagic.data.Converters
import com.example.immagic.database.interfaceDao.*
import java.io.FileOutputStream

@Database(
    entities = [
        User::class,
        Quote::class,
        UserActionsQuote::class,
        CourseCardSet::class,
        Course::class,
        Category::class,
        Level::class,
        LevelBonus::class,
        UnlockedFunction::class,
        CategoryCardSet::class,
        Subcategory::class,
        UserCreatedNotifications::class,
        UserCreatedQuotes::class,
        TreasureChest::class,
        ChestReward::class,
        Rewards::class,
        UserEquipment::class,
        LoginHistoryLog::class,
        CardSetPrice::class,
        CardSetLevel::class,
        SubcategoriesBridge::class,
        FavouriteCardSet::class

               ],

    version = 1, exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun cardSetLevel(): CardSetLevelDao
    abstract fun cardSetPrice(): CardSetPriceDao
    abstract fun course(): CourseDao
    abstract fun category(): CategoryDao
    abstract fun subCategory(): SubcategoryDao
    abstract fun treasureChest(): TreasureChestDao
    abstract fun rewards(): RewardsDao
    abstract fun chestReward(): ChestRewardDao
    abstract fun level(): LevelDao
    abstract fun courseCardSet(): CourseCardSetDao
    abstract fun loginHistoryLog(): LoginHistoryLogDao

    abstract fun levelBonus(): LevelBonusDao
    abstract fun userCreatedQuotes(): UserCreatedQuotesDao
    abstract fun userEquimpment(): UserEquipmentDao

    abstract fun quote(): QuoteDao
    abstract fun userActionsQuote(): UserActionsQuoteDao

    abstract fun favouriteCardSet(): FavouriteCardSetDao


    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Migracja z wersji 1 do 2
                // Wykonaj zmiany w bazie danych, np. ALTER TABLE, itp.
            }
        }


        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = buildDatabase(context.applicationContext)
                INSTANCE = instance
                instance
            }
        }

        private fun buildDatabase(appContext: Context): AppDatabase {
            val builder = Room.databaseBuilder(
                appContext,
                AppDatabase::class.java,
                "mydatabase"
            ).addMigrations(MIGRATION_1_2)

            if (!databaseExists(appContext, "mydatabase")) {
                // Wywołaj funkcję kopiującą dane tylko jeśli baza danych jeszcze nie istnieje
                copyDataToDatabase(appContext)
            }

            return builder.build()
        }


        private fun copyDatabaseFromAssets(context: Context, assetFileName: String, destinationPath: String) {
            val inputStream = context.assets.open("database/$assetFileName")
            val outputStream = FileOutputStream(destinationPath)

            inputStream.use { input ->
                outputStream.use { output ->
                    input.copyTo(output)
                }
            }
        }

        private fun copyDataToDatabase(context: Context) {
            val destinationPath = context.getDatabasePath("mydatabase").absolutePath
            copyDatabaseFromAssets(context, "mydatabase.sqlite", destinationPath)
        }

        private fun databaseExists(context: Context, databaseName: String): Boolean {
            val dbFile = context.getDatabasePath(databaseName)
            return dbFile.exists()
        }



    }
}
