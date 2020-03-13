package com.example.sendotp

import android.app.Application
import com.example.sendotp.di.AppComponent
import com.example.sendotp.di.DaggerAppComponent
import com.facebook.stetho.Stetho

class SendOTPApp : Application(){

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
