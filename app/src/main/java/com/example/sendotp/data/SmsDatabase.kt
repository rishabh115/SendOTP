package com.example.sendotp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.sendotp.data.model.SmsHistory
import com.example.sendotp.util.DateConverters

/**
 * Provides singleton instance of database that is used throughout the application.
 */
@Database(entities = [SmsHistory::class], version = 1, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class SmsDatabase : RoomDatabase() {
    abstract fun smsDao(): SmsHistoryDao

    companion object{
        @Volatile
        private var INSTANCE: SmsDatabase? = null

        fun getDatabase(context: Context): SmsDatabase{
            if (INSTANCE==null){
                synchronized(this){
                    if (INSTANCE==null){
                        INSTANCE = create(context, false)
                    }
                }
            }
            return INSTANCE!!
        }

        fun create(context: Context, memoryOnly: Boolean): SmsDatabase{
           val builder: RoomDatabase.Builder<SmsDatabase>
           if (memoryOnly){
               builder = Room.inMemoryDatabaseBuilder(context, SmsDatabase::class.java)
           } else{
               builder = Room.databaseBuilder(context.applicationContext,
                   SmsDatabase::class.java,"sms_database")
           }
          return builder.build()
        }
    }
}