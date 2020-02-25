package com.example.sendotp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Model class for message item of successful response.
 */
data class Message(@SerializedName("to") val to:String,
                   @SerializedName("message-id") val messageId:String,
                   @SerializedName("status") val status: String,
                   @SerializedName("remaining-balance")val remainingBalance: String,
                   @SerializedName("message-price") val messagePrice: String,
                   @SerializedName("network") val network: String)