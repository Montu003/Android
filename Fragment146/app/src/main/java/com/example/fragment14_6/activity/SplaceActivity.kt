package com.example.fragment14_6.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment14_6.R

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Thread(
            Runnable {
                Thread.sleep(5000)
                startActivity(Intent(this,AuthActivity::class.java))
            }
        ).start()
    }
}