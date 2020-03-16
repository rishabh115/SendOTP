package com.example.sendotp.util

import android.content.Context
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * File containing various top-level utility functions
 */
const val HISTORY_TIME_FORMAT = "hh:mm a"
fun formatTime(date: Date): String{
    return SimpleDateFormat(HISTORY_TIME_FORMAT).format(date)
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}

fun getRandomNumber():Int{
    return Random().nextInt(900000)+100000
}

fun formatPhoneNumber(phone:String): String{
    val res = phone.replace("+","").replace("-","")
    return res
}

fun <T> LiveData<T>.blockingObserve():T{
    var value: T? = null
    val latch = CountDownLatch(1)

    val observer = object : Observer<T>{
        override fun onChanged(t: T) {
            value = t
            latch.countDown()
            this@blockingObserve.removeObserver(this)
        }
    }

    Handler(Looper.getMainLooper()).post{
        observeForever(observer)
    }

    latch.await(2,TimeUnit.SECONDS)
    return value!!
}