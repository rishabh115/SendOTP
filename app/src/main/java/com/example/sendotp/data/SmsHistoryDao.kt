package com.example.sendotp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.sendotp.data.model.SmsHistory

/**
 * Dao for performing read and write on local db.
 */
@Dao
interface SmsHistoryDao {
    @Query("SELECT * from smshistory ORDER BY sentTime DESC")
    fun getSentSms(): LiveData<List<SmsHistory>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addSentSms(smsHistory: SmsHistory)
}