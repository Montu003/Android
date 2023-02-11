package com.example.allproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.allproject.sharePref.PrefManager
import com.example.uidesign21_6.LoginActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<Button>(R.id.btn_logout).setOnClickListener {

//            var prefManager = PrefManager(this)
//            prefManager.setLoginStatus(false)
//
            startActivity(Intent(this,LoginActivity::class.java))
            finishAffinity()
        }
    }
}