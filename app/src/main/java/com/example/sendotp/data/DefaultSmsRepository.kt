package com.example.sendotp.data

import androidx.lifecycle.LiveData
import com.example.sendotp.data.model.SmsHistory

/**
 * Repository class for handling database related operations.
 */
class SmsRepository(private val smsHistoryDao: SmsHistoryDao) {

    val allSmsHistory: LiveData<List<SmsHistory>> = smsHistoryDao.getSentSms()

    fun addSentSms(smsHistory: SmsHistory){
        smsHistoryDao.addSentSms(smsHistory)
    }

}