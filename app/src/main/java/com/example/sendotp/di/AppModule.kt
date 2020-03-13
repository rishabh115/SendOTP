package com.example.sendotp.di

import android.app.Application
import android.content.Context
import com.example.sendotp.data.SmsDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object AppModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application):SmsDatabase{
      return SmsDatabase.getDatabase(application.applicationContext)
    }
}