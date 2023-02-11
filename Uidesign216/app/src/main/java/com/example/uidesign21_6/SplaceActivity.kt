package com.example.uidesign21_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Thread(
            Runnable {
                Thread.sleep(3000)
                startActivity(Intent(this,LoginActivity::class.java))
            }
        ).start()

    }
}