package com.example.immagic.data
import androidx.room.TypeConverter
import java.util.Date

class Converters {
    @TypeConverter
    fun fromDate(value: Long?): Date? {
        return if (value == null) null else Date(value)
    }

    @TypeConverter
    fun toDate(date: Date?): Long? {
        return date?.time
    }
}
