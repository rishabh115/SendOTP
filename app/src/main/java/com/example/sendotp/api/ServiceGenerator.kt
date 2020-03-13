package com.example.sendotp.api

import com.example.sendotp.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory

/**Client responsible for creating Sms service instance.
 */
object ServiceGenerator {

        fun retrofit():Retrofit{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit
        }

        fun <S> createService(serviceClass: Class<S>): S{
            return retrofit().create(serviceClass)
        }
}