package com.example.sendotp.util

import androidx.room.TypeConverter
import java.util.*

/**
 * TypeConverter for Date object so that it can stored in the db.
 * Room does not have out of the box support for Date object.
 */
object DateConverters {
    @TypeConverter
    @JvmStatic
    fun fromTimestamp(value: Long): Date{
        return Date(value)
    }

    @TypeConverter
    @JvmStatic
    fun dateToTimestamp(date: Date): Long{
        return date.time
    }
}