package com.example.sendotp.ui.details

import android.app.Application
import android.telephony.PhoneNumberUtils
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.example.sendotp.FAILURE_MSG
import com.example.sendotp.FROM
import com.example.sendotp.PHONE_FORMAT_WRONG_MSG
import com.example.sendotp.api.ApiClient
import com.example.sendotp.api.SmsService
import com.example.sendotp.data.SmsDatabase
import com.example.sendotp.data.SmsRepository
import com.example.sendotp.data.model.SmsHistory
import com.example.sendotp.data.model.SmsRequest
import com.example.sendotp.data.model.SmsResponse
import com.example.sendotp.util.ErrorUtils
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * ViewModel for Contact Details activity.
 * Contains method for sending sms and adding successfully sent msg to local db.
 */
class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val smsRepository: SmsRepository
    private val smsService: SmsService
    private val executor: Executor

    init {
        val smsHistoryDao = SmsDatabase.getDatabase(application).smsDao()
        smsRepository = SmsRepository(smsHistoryDao)
        smsService = ApiClient.createSmsService()
        executor = Executors.newFixedThreadPool(5)
    }

    /**
     * Method for adding a successfully sent msg.
     * Used executor thread pool to avoid main thread db write issues.
     */
    fun addSentSms(smsHistory: SmsHistory){
        executor.execute { smsRepository.addSentSms(smsHistory)  }
    }

    fun sendSms(smsRequest: SmsRequest, otp: Int, name: String, callback: com.example.sendotp.data.Callback){

       val to = smsRequest.to
       if (!PhoneNumberUtils.isGlobalPhoneNumber(to)){ //Validating the phone number
           callback.onFailure(PHONE_FORMAT_WRONG_MSG)
           return
       }
       val response =  smsService.sendSms(smsRequest.apiKey, smsRequest.apiSecret,
           FROM, smsRequest.to, smsRequest.text)
       response.enqueue(object : Callback<SmsResponse>{
           override fun onResponse(call: Call<SmsResponse>, response: Response<SmsResponse>) {
               if (response.isSuccessful()) {
                   Log.d("Details", "Success ${Gson().toJson(response.body())}")
                   val smsHistory = SmsHistory(name, Date(),otp.toString())
                   addSentSms(smsHistory) //Add sms to db in case of success
                   callback.onSuccess()
               }
               else {
                 //  val error = ErrorUtils.parseError(response)
                   callback.onFailure(FAILURE_MSG)
                //    callback.onFailure(error?.messages[0].errorText)
                //    Log.d("Details", "Failure ${Gson().toJson(error)}")
               }
           }

           override fun onFailure(call: Call<SmsResponse>, t: Throwable) {
                 callback.onFailure(FAILURE_MSG)
           }
       })
    }

}