package com.example.sendotp.data

import androidx.test.InstrumentationRegistry
import androidx.test.runner.AndroidJUnit4
import com.example.sendotp.data.model.SmsHistory
import com.example.sendotp.util.blockingObserve
import junit.framework.Assert.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class SmsTests {
    lateinit var db: SmsDatabase
    lateinit var smsDao: SmsHistoryDao

    @Before
    fun setUp(){
      db = SmsDatabase.create(InstrumentationRegistry.getContext(), true)
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