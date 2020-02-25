package com.example.sendotp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.sendotp.util.DateConverters
import java.util.*

/**
 * Entity class for sms records stored in the database.
 */
@Entity(tableName = "smshistory")
data class SmsHistory(val name: String,  val sentTime: Date, val otp: String){
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}