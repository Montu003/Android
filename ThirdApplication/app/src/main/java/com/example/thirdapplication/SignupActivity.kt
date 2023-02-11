package com.example.thirdapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignupActivity : AppCompatActivity() {

    lateinit var etName : TextView
    lateinit var etemail:TextView
    lateinit var etage:TextView
    lateinit var next:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etName = findViewById(R.id.et_name_third)
        etemail = findViewById(R.id.et_Email_third)
        etage= findViewById(R.id.et_Age_third)

        var Name = intent.getStringExtra("Name")
        var Email = intent.getStringExtra("Email")
        var Age = intent.getStringExtra("Age")

        etName.text = "Name : $Name"
        etemail.text = "Email : $Email"
        etage.text = "Age : $Age"

        next.setOnClickListener{

            var Name = etName.text.toString().trim()
            var Email = etemail.text.toString().trim()
            var Age = etage.text.toString().trim()

            var intent = Intent(this,ForgotActivity::class.java)
            intent.putExtra("Name",Name)
            intent.putExtra("Email",Email)
            intent.putExtra("Age",Age)
            startActivity(intent)
        }
    }
}