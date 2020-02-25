package com.example.sendotp.api

import com.example.sendotp.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**Client responsible for creating Sms service instance.
 */
class ApiClient {
    companion object {
        @JvmStatic
        fun retrofit():Retrofit{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit
        }
        @JvmStatic
        fun createSmsService(): SmsService{
            return retrofit().create(SmsService::class.java)
        }
    }
}