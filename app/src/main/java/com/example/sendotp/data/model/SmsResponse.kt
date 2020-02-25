package com.example.sendotp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Model class for successful sms sent response.
 */
data class SmsResponse(@SerializedName("message-count")val messageCount:String,
                       @SerializedName("messages")val messages: List<Message>)