package com.example.secondapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {

    lateinit var tvName:TextView
    lateinit var tvEmail:TextView
    lateinit var tvAge:TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        tvName  =findViewById(R.id.tvName)
        tvEmail = findViewById(R.id.tvEmail)
        tvAge  = findViewById(R.id.tvAge)
        button = findViewById(R.id.btn_submit)

        var name = intent.getStringExtra("Name")
        var email = intent.getStringExtra("Email")
        var age = intent.getStringExtra("Age")

        tvName.text = "Name : $name"
        tvEmail.text = "Email : $email"
        tvAge.text = "Age : $age"

        button.setOnClickListener{

            var Name = tvName.text.toString().trim()
            var Email = tvEmail.text.toString().trim()
            var Age = tvAge.text.toString().trim()

            var intent = Intent(this,ThirdActivity::class.java)
            intent.putExtra("Name",Name)
            intent.putExtra("Email",Email)
            intent.putExtra("Age",Age)
            startActivity(intent)
        }
    }
}