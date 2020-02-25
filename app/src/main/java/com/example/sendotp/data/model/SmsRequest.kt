package com.example.sendotp.data.model

import com.example.sendotp.API_KEY
import com.example.sendotp.API_SECRET

/**
 * Model class for storing attributes required for making api request.
 */
data class SmsRequest(val to: String, val from: String, val text: String) {
    val apiKey = API_KEY
    val apiSecret = API_SECRET
    override fun toString(): String {
        val builder = StringBuilder()
        builder.apply {
            append("api_key=${API_KEY}\n")
            append("api_secret=${API_SECRET}\n")
            append("to=${to}\n")
            append("from=\"${from}\"\n")
            append("text=\"${text}\"")
        }
        return builder.toString()
    }
}