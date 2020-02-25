package com.example.sendotp.util

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import java.text.SimpleDateFormat
import java.util.*

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