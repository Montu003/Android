package com.example.khodal.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.khodal.R

class SplachActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splach)


        Thread(
            Runnable {
                Thread.sleep(5000)
                startActivity(Intent(this,AuthActivity::class.java))
            }
        ).start()

    }
}