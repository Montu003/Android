package com.example.onboardingscreen.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onboardingscreen.R

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this,IntroActivity::class.java))
            }
        ).start()

    }
}