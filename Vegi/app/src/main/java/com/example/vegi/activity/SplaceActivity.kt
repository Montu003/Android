package com.example.vegi.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.vegi.R

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Looper.myLooper()?.let {
            Handler(it).postDelayed(Runnable {
                startActivity(Intent(this, MainActivity::class.java))
                finishAffinity()
            }, 2000)
        }

    }
}