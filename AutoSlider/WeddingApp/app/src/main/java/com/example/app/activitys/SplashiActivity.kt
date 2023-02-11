package com.example.app.activitys

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.app.MainActivity
import com.example.app.shredpref.PrefManagr
import com.example.weddingapp.databinding.ActivitySplashiBinding

class SplashiActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var prefManagr = PrefManagr(this)
        val title = intent.extras?.getString("title")
        val message = intent.extras?.getString("message")

        Handler(Looper.myLooper()!!).postDelayed({
            if (!prefManagr.getLoginStatus() && intent.extras == null) {
                startActivity(Intent(this, LoginActivity::class.java))
            } else if (prefManagr.getLoginStatus() || intent.extras != null) {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("title", title)
                intent.putExtra("message", message)
                startActivity(intent)
            }
            finish()
        }, 2000)

    }
}