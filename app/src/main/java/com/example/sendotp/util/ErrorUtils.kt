package com.example.sendotp.util

import com.example.sendotp.api.ServiceGenerator
import com.example.sendotp.data.model.ApiError
import retrofit2.Response
import java.lang.Exception

/**
 * Utitlity class for parsing error.
 */
object ErrorUtils {
    fun parseError(response: Response<*>): ApiError?{
        val converter = ServiceGenerator.retrofit()
            .responseBodyConverter<ApiError>(ApiError::class.java,
            arrayOfNulls<Annotation>(0))
        var error:ApiError?=null
        try {
            error = converter.convert(response.errorBody())
        }
        catch (e: Exception){
            e.printStackTrace()
        }
        return error
    }
}