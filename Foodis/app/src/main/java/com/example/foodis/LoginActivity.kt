package com.example.foodis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
   /* lateinit var et_email:EditText*/
    lateinit var btnfpassword:Button
    lateinit var btnSignup:Button
    lateinit var btnlogin:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnfpassword = findViewById(R.id.btn_fpassword)
        btnSignup = findViewById(R.id.btn_signup)
        btnlogin = findViewById(R.id.btn_login)

        btnfpassword.setOnClickListener {

            var intent = Intent(this,ForgotActivity::class.java)
            startActivity(intent)
        }
        btnSignup.setOnClickListener {

            var intent = Intent(this, SigupActivity::class.java)
            /* intent.putExtra("email", et_email.text.toString())*/
            startActivity(intent)
        }

        btnlogin.setOnClickListener {

            var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        }
    }
}