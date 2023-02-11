package com.example.hotelapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import com.example.hotelapplication.databinding.ActivityLoginBinding
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")


    val btnSignUp:Button
        get() = findViewById(R.id.btn_signup)

    val btnLogin:Button
        get()=findViewById(R.id.login_button)

    val btforgot:Button
    get() = findViewById(R.id.bt_forgot)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnLogin.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()

     /*       if(isvalideemail(email) && isvalidepassword(password)){
                val intent=Intent(this,HomeActivity::class.java)
                intent.putExtra("email",binding.etEmail.text.toString())
                intent.putExtra("password",binding.etPassword.text.toString())
                startActivity(intent)
            }else{
                Toast.makeText(this, "error in email or password", Toast.LENGTH_SHORT).show()
            }*/
            if (email.isEmpty())
            {
                binding.etEmail.error = "Enter your email"
                Toast.makeText(this, "error email", Toast.LENGTH_SHORT).show()

            }else if (!isvalidepassword(password))
            {
                binding.etPassword.error = "Enter valid password"
                Toast.makeText(this, "error password", Toast.LENGTH_SHORT).show()
            }else
            {
                Toast.makeText(applicationContext,"all fields ave vaildated",Toast.LENGTH_SHORT).show()
                val intent=Intent(this,HomeActivity::class.java)
                intent.putExtra("email",binding.etEmail.text.toString())
                intent.putExtra("password",binding.etPassword.text.toString())
                startActivity(intent)
            }
        }
        btnSignUp.setOnClickListener {
            startActivity(Intent(this,SignupActivity::class.java))
        }
        btforgot.setOnClickListener {
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
