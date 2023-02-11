package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class FirstActivity : AppCompatActivity() {

    lateinit var btnsubmit:Button
    lateinit var etName:EditText
    lateinit var etEmail:EditText
    lateinit var etAge:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        btnsubmit = findViewById(R.id.btn_submit)
        etName = findViewById(R.id.et_name)
        etEmail = findViewById(R.id.et_email)
        etAge = findViewById(R.id.et_age)

        //Button click event
        btnsubmit.setOnClickListener{

            //this block will be execute if user click the submit button

            var name= etName.text.toString().trim()
            var email = etEmail.text.toString().trim()
            var age = etAge.text.toString().trim()

           // println("name : $name email : $email age : $age")
            //navigate from FirstActivity to secondActivity
            var intent  = Intent(this,SecondActivity::class.java)
            intent.putExtra("Name",name)
            intent.putExtra("Email",email)
            intent.putExtra("Age",age)
            startActivity(intent)
        }
    }
}