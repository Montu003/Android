package com.example.logintocontinueapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    lateinit var tv_Email:TextView
    lateinit var tv_Password:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tv_Email = findViewById(R.id.tv_Email)
        tv_Password = findViewById(R.id.tv_Password)

        var Email = intent.getStringExtra("Email")
        var Password = intent.getStringExtra("Password")

        tv_Email.text = "Email : $Email"
        tv_Password.text = "Password : $Password"

    }
}