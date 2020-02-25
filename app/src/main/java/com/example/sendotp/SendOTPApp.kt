package com.example.sendotp

import android.app.Application
import com.facebook.stetho.Stetho

class SendOTPApp : Application(){
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}
