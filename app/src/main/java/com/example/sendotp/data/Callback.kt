package com.example.sendotp.data

/**
 * Interface for handling the api responses.
 */
interface Callback {
    fun onSuccess()
    fun onFailure(errorMsg:String)
}