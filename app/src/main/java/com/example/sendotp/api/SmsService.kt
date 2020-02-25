package com.example.sendotp.api

import com.example.sendotp.BASE_URL
import com.example.sendotp.data.model.SmsResponse
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

/**
 * Interface for nexmo sms api.
 */
interface SmsService{

    @FormUrlEncoded
    @POST("sms/json")
    fun sendSms(@Field("api_key") apiKey: String,
                @Field("api_secret") apiSecret:String,
                @Field("from") from: String,
                @Field("to") to: String,
                @Field("text") text: String):Call<SmsResponse>
}