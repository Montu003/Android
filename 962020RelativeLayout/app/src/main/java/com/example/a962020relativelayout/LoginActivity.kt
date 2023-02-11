package com.example.a962020relativelayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    val btn_signup:Button
    get() = findViewById(R.id.btn_signup)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btn_signup.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
    }
}