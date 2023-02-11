package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.design.databinding.ActivityLogin1Binding
import com.example.design.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLogin1Binding
    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    val btnSignup:TextView
        get() =findViewById(R.id.btn_Signup)

    val btn_Forgot:TextView
    get() = findViewById(R.id.btn_Forgot)

    val btn_Loginhome:Button
    get() = findViewById(R.id.btn_Loginhome)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogin1Binding.inflate(layoutInflater)
        setContentView(binding.root)
      initListener()
    }

    private fun initListener() {
        btn_Loginhome.setOnClickListener {
            var email = binding.tvEmail.toString().trim()
            var password = binding.tvPassword.toString().trim()

            if (!isvalideemail(email)){
                Toast.makeText(this, "error email", Toast.LENGTH_SHORT).show()
            }
            else if (!isvalidepassword(password)){
                Toast.makeText(this, "error password", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "all fields are vaildated", Toast.LENGTH_SHORT).show()
            }
        }
        btnSignup.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
        btn_Forgot.setOnClickListener {
            startActivity(Intent(this,ForgotActivity::class.java))
        }
    }

    private fun isvalideemail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isvalidepassword(password:String):Boolean
    {
        return  Pattern.compile(REGEX).matcher(password).matches()
    }
}