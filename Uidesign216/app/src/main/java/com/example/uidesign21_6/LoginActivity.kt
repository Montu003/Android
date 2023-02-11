package com.example.uidesign21_6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.hotelapplication.SignupActivity
import com.example.uidesign21_6.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding:ActivityLoginBinding

    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    val btnSignup:Button
    get() = findViewById(R.id.btn_Signup)

    val btnforgot:Button
    get() = findViewById(R.id.btn_forgot)

    val button4:Button
    get() = findViewById(R.id.button4)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSignup.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }

        binding.btnForgot.setOnClickListener {
            startActivity(Intent(this,ForgotActivity::class.java))
        }

        binding.button4.setOnClickListener {

            var email = binding.tvEmail.text.toString().trim()
            var password = binding.tvPassword.text.toString().trim()

            if(isvalidemail(email) && isvalidpassword(password))
            {
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("email",binding.tvEmail.text.toString())
                intent.putExtra("password",binding.tvPassword.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this,"error in email or password",Toast.LENGTH_SHORT).show()
            }
            if (!isvalidemail(email))
            {
                binding.tvEmail.error = "Enter your email"
                Toast.makeText(this,"error email",Toast.LENGTH_SHORT).show()
            }else if (!isvalidpassword(password))
            {
                binding.tvPassword.error = "Enter valid password"
                Toast.makeText(this,"error password",Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun isvalidemail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isvalidpassword(password:String):Boolean
    {
        return Pattern.compile(REGEX).matcher(password).matches()
    }
}