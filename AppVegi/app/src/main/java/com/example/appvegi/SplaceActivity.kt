package com.example.appvegi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appvegi.Fragment.HomeFragment

class SplaceActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)

        Thread(
            Runnable {
                        Thread.sleep(3000)
                        startActivity(Intent(this,HomeActivity::class.java))
            }
        ).start()

    }
}