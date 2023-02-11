package com.example.logintocontinueapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var et_Email:EditText
    lateinit var et_Password:EditText
    lateinit var btn_login:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        et_Email=findViewById(R.id.et_Email)
        et_Password=findViewById(R.id.et_Password)
        btn_login=findViewById(R.id.btn_login)

        btn_login.setOnClickListener {

            //this block will be execute if user click the submit button

             var Email = et_Email.text.toString().trim()
             var Password = et_Password.text.toString().trim()

             // println("name : $name email : $email age : $age")
             //navigate from FirstActivity to secondActivity*/
            var intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("Email", Email)
            intent.putExtra("Password", Password)
            startActivity(intent)
        }
    }
}