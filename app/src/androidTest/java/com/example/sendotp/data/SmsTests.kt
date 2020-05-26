package com.example.sendotp

import androidx.test.InstrumentationRegistry
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.runner.AndroidJUnit4
import com.example.sendotp.data.SmsDatabase
import com.example.sendotp.data.SmsHistoryDao
import com.example.sendotp.data.model.SmsHistory
import com.example.sendotp.util.blockingObserve
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test

import java.util.*

class SmsTests {
    lateinit var db: SmsDatabase
    lateinit var smsDao: SmsHistoryDao

    @Before
    fun setUp(){
      db = SmsDatabase.create(
          getApplicationContext(),
          true
      )
      smsDao = db.smsDao()
    }

    @After
    fun tearDown(){
      db.close()
    }

    @Test
    fun basics(){
        assertEquals(0, smsDao.getSentSms().blockingObserve().size)
        val smsHistory = SmsHistory("Rishabh", Date(),"123456")
        assertNotNull(smsHistory.id)
        smsDao.addSentSms(smsHistory)
        assertEquals(1, smsDao.getSentSms().blockingObserve().size)

        smsDao.clearAllSentSms()
        assertEquals(0, smsDao.getSentSms().blockingObserve().size)
    }
}