package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.design.databinding.ActivitySignupBinding
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignupBinding
    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    val btnLogin:Button
    get() = findViewById(R.id.btn_Login)

    val btn_Registration:Button
    get() = findViewById(R.id.btn_Registration)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btn_Registration.setOnClickListener {

            var email = binding.ivEmail.toString().trim()
            var password = binding.ivPassword.toString().trim()
            var name = binding.ivName.toString().trim()
            var comapny = binding.ivCompany.toString().trim()
            var contact = binding.ivContact.toString().trim()

            if (!isvaildemail(email))
            {
               // binding.ivEmail.error = "Enter email"
                Toast.makeText(this, "Enter email", Toast.LENGTH_SHORT).show()
            }
            else if(!isvaildpassword(password))
            {
                //binding.ivPassword.error = "Enter password"
                Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show()
            }
            else if (name.isEmpty())
            {
                //binding.ivName.error = "Enter name"
                Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show()
            }
            else if (comapny.isEmpty())
            {
                //binding.ivCompany.error = "Enter name"
                Toast.makeText(this, "Enter comapny name", Toast.LENGTH_SHORT).show()
            }
            else if(!isvaildcontact(contact))
            {
                //binding.ivCompany.error = "Enter name"
                Toast.makeText(this, "Enter contact", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "all fields are vaildated", Toast.LENGTH_SHORT).show()
            }
        }
        btnLogin.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }
    }
    private fun isvaildemail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isvaildpassword(password:String):Boolean
    {
        return Pattern.compile(REGEX).matcher(password).matches()
    }
    private fun isvaildcontact(contact:String):Boolean
    {
        return contact.length==10
    }
}