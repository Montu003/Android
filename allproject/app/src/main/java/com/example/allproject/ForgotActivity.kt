package com.example.allproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.uidesign21_6.LoginActivity

class ForgotActivity : AppCompatActivity() {

    val btnLogin: ImageView
        get() = findViewById(R.id.btn_back)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

    }
}