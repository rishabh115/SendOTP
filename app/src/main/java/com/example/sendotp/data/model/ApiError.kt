package com.example.sendotp.data.model

import com.google.gson.annotations.SerializedName


/**
 * Model classes for error.
 */
data class ErrorMessage(@SerializedName("status")val status: String,
                        @SerializedName("error-text")val errorText: String)

data class ApiError(@SerializedName("message-count") val messageCount: Int,
                    @SerializedName("messages")val messages: List<ErrorMessage>)