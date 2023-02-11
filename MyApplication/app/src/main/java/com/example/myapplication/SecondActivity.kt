package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.util.jar.Attributes

class SecondActivity : AppCompatActivity() {

    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvAge:TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvName = findViewById(R.id.tv_name)
        tvEmail = findViewById(R.id.tv_email)
        tvAge = findViewById(R.id.tv_age)

        //println("name : $name email : $email age : $age")
        var name = intent.getStringExtra("Name")
        var email = intent.getStringExtra("Email")
        var age = intent.getStringExtra("Age")


        tvName.text = "Name : $name"
        tvEmail.text = "Email : $email"
        tvAge.text = "Age : $age"
    }
}