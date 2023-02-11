package com.example.thirdapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class ForgotActivity : AppCompatActivity() {

    lateinit var name: TextView
    lateinit var email: TextView
    lateinit var age: EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)


        name = findViewById(R.id.et_name_third)
        email = findViewById(R.id.et_Email_third)
        age = findViewById(R.id.et_Age_third)

        var Name = intent.getStringExtra("Name")
        var Email = intent.getStringExtra("Email")
        var Age = intent.getStringExtra("Age")


        name.text = "$Name"
        email.text = "$Email"
        age.setText("$Age")

    }

}