package com.example.vegiapp.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.vegiapp.utils.SessionManager

open class BaseActivity : AppCompatActivity() {

    lateinit var sessionManager: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sessionManager= SessionManager(this)
    }
}