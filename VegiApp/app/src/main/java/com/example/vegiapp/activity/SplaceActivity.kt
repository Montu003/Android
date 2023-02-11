package com.example.vegiapp.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.vegiapp.R

class SplaceActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splace)


        Looper.myLooper()?.let {
            Handler(it).postDelayed(Runnable {
                startActivity(Intent(this, HomeActivity::class.java))
                finishAffinity()
            }, 2000)
        }
    }
}