package com.example.sendotp.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * Base activity for making activities future adaptable.
 */
abstract class BaseActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}