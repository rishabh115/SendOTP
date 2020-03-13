package com.example.sendotp.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.example.sendotp.data.SmsDatabase
import com.example.sendotp.data.SmsRepository
import com.example.sendotp.data.model.Contact
import com.example.sendotp.data.model.SmsHistory
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

/**
 * Viewmodel for home activity and its fragments.
 */
class HomeViewModel @Inject constructor(val app:Application, smsDatabase: SmsDatabase) {

    private val smsRepository: SmsRepository
    private val _contacts = MutableLiveData<List<Contact>>()

    init {
        smsRepository = SmsRepository(smsDatabase.smsDao())
    }

   fun getContacts():LiveData<List<Contact>>{
       val contactsJson = app.assets.open("contacts.json").bufferedReader().use { it.readText() }
       val contactListType = object:TypeToken<ArrayList<Contact>>(){}.type
       _contacts.value = Gson().fromJson(contactsJson, contactListType)
       return _contacts
   }

   fun getSmsHistory(): LiveData<List<SmsHistory>> = smsRepository.allSmsHistory

   fun addSentSms(smsHistory: SmsHistory){
       smsRepository.addSentSms(smsHistory)
   }
}