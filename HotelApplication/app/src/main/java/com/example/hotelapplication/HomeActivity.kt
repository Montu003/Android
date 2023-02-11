package com.example.hotelapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    lateinit var tv_name: TextView
    lateinit var tv_email: TextView
    lateinit var tv_contact: TextView
    lateinit var tv_Password: TextView
    lateinit var tv_Confirmpassword: TextView
    /*lateinit var tv_loginEmail: TextView
    lateinit var tv_loginpassword: TextView*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        tv_name = findViewById(R.id.tv_Name)
        tv_email = findViewById(R.id.tv_Email)
        tv_contact = findViewById(R.id.tv_Contact)
        tv_Password = findViewById(R.id.tv_Password)
        tv_Confirmpassword = findViewById(R.id.tv_Confirmpassword)

        var name = intent.getStringExtra("name")
        var email = intent.getStringExtra("email")
        var contact = intent.getStringExtra("contact")
        var password = intent.getStringExtra("password")
        var Confirmpassword = intent.getStringExtra("Confirmpassword")

        tv_email.text = "Email : $email"
        tv_Password.text = "Password : $password"
        if(name!=null)
            tv_name.text = "Name : $name"
        if(contact!=null)
            tv_contact.text = "Contact : $contact"
        if (Confirmpassword!=null)
            tv_Confirmpassword.text = "Confirmpassword : $Confirmpassword"
    }
}