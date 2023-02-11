package com.example.foodis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.thirdapplication.ForgotActivity
import com.example.thirdapplication.R
import com.example.thirdapplication.SignupActivity

class LoginActivity : AppCompatActivity() {
    lateinit var et_email:EditText
    lateinit var et_password:EditText
    lateinit var btn_login:Button
    lateinit var fpassword:Button
    lateinit var signup:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        et_email=findViewById(R.id.et_email)
        et_password=findViewById(R.id.et_password)
        btn_login=findViewById(R.id.btn_login)
        fpassword=findViewById(R.id.btn_f_password)
        signup=findViewById(R.id.btn_signup)

        fpassword.setOnClickListener {

            var intent= Intent(this, ForgotActivity::class.java)
            startActivity(intent)
        }
        signup.setOnClickListener {

            var intent = Intent(this,SignupActivity::class.java)
            intent.putExtra("email", et_email.text.toString())
            startActivity(intent)

        }
    }
}