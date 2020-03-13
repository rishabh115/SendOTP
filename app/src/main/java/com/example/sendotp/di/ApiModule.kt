package com.example.sendotp.di

import com.example.sendotp.BASE_URL
import com.example.sendotp.api.SmsService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    @Provides
    fun provideSmsService(retrofit: Retrofit): SmsService{
        return retrofit.create(SmsService::class.java)
    }
}