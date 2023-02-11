package com.example.design

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.example.design.databinding.ActivityForgotBinding

class ForgotActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotBinding
    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    val btnsubmit:Button
    get() = findViewById(R.id.btn_submit)

    val btnback:ImageView
    get() = findViewById(R.id.btn_Back)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityForgotBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnback.setOnClickListener {
            startActivity(Intent(this,LoginActivity::class.java))
        }

        btnsubmit.setOnClickListener {

            var btnEmail = binding.btnEmail.text.toString().trim()

            if (!isvaildemail(btnEmail))
            {
                binding.btnEmail.error = "Enter email/mobile number"
                Toast.makeText(this, "Enter email/mobile number", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isvaildemail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}