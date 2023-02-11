package com.example.secondapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.time.measureTimedValue

class ThirdActivity : AppCompatActivity()
{
    lateinit var tvName: TextView
    lateinit var tvEmail: TextView
    lateinit var tvAge: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        tvName = findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvAge = findViewById(R.id.tvAge)

        var name = intent.getStringExtra("Name")
        var email = intent.getStringExtra("Email")
        var age = intent.getStringExtra("Age")


        tvName.text = name
        tvEmail.text = email
        tvAge.text = age
    }
}