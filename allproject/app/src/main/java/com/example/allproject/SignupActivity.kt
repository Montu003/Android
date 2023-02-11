package com.example.hotelapplication

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.allproject.HomeActivity
import com.example.allproject.R
import com.example.allproject.databinding.ActivitySignupBinding
import com.example.allproject.sharePref.PrefManager
import com.example.uidesign21_6.LoginActivity
import java.util.regex.Pattern

class SignupActivity : AppCompatActivity() {


    val btnLogin:ImageView
        get() = findViewById(R.id.btn_BACK)

    private lateinit var binding: ActivitySignupBinding

    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignupBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

        binding.button.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var Confirmpassword = binding.etConfirmpassword.text.toString().trim()

            /*           if (isValidContact(contact) && isValidEmail(email) && isValidPassword(password) && isValidConfirmpassword(Confirmpassword))
                       {
                           val intent=Intent(this,HomeActivity::class.java)
                           intent.putExtra("name",binding.etName.text.toString())
                           intent.putExtra("contact",binding.etContact.text.toString())
                           intent.putExtra("email",binding.etEmail.text.toString())
                           intent.putExtra("password",binding.etPassword.text.toString())
                           intent.putExtra("Confirmpassword",binding.etConfirmpassword.text.toString())
                           startActivity(intent)
                       }else
                       {
                           Toast.makeText(this, "error in name or contact or email or password or confirmpassword", Toast.LENGTH_SHORT).show()
                       }*/

            resetFocus()

            if (name.isEmpty()) {
                // show error
                setError(binding.etName, "Enter your name")
                // binding.etName.error = "Enter your name"
                //Toast.makeText(this, "error name", Toast.LENGTH_SHORT).show()
            } else if (!isValidContact(contact)) {
                setError(binding.etContact, "Enter valid contact number")
                //binding.etContact.error = "Enter valid contact number"
                //Toast.makeText(this, "error contact", Toast.LENGTH_SHORT).show()
            } else if (!isValidEmail(email)) {

                setError(binding.etEmail, "Enter valid email address")
                //binding.etEmail.error = "Enter valid email address"
                //Toast.makeText(this, "error email", Toast.LENGTH_SHORT).show()
            } else if (!isValidPassword(password)) {
                setError(binding.etPassword, "Enter valid password")
                // binding.etPassword.error = "Enter valid password"
                //Toast.makeText(this, "error password", Toast.LENGTH_SHORT).show()
            } else if (!isValidConfirmpassword(Confirmpassword)) {
                setError(binding.etConfirmpassword, "Enter valid Confirmpassword")
                // binding.etConfirmpassword.error = "Enter valid Confirmpassword"
                //  Toast.makeText(this, "error Confirmpassword", Toast.LENGTH_SHORT).show()
            } else {
                // navigate to home
                Toast.makeText(this, "All fields are validated", Toast.LENGTH_SHORT).show()
                var prefManager = PrefManager(this)
                prefManager.setLoginStatus(true)
                startActivity(Intent(this,HomeActivity::class.java))
/*
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("name", binding.etName.text.toString())
                intent.putExtra("Contact", binding.etContact.text.toString())
                intent.putExtra("email", binding.etEmail.text.toString())
                intent.putExtra("password", binding.etPassword.text.toString())
                intent.putExtra("Confirpassword", binding.etConfirmpassword.text.toString())
                startActivity(intent)*/
            }
        }
    }
    private fun resetFocus() {
        binding.etName.background = ContextCompat.getDrawable(this,R.drawable.background)
        binding.etContact.background = ContextCompat.getDrawable(this,R.drawable.background)
        binding.etEmail.background = ContextCompat.getDrawable(this,R.drawable.background)
        binding.etPassword.background = ContextCompat.getDrawable(this,R.drawable.background)
        binding.etConfirmpassword.background = ContextCompat.getDrawable(this,R.drawable.background)

        binding.etPassword.clearFocus()
        binding.etName.clearFocus()
        binding.etEmail.clearFocus()
        binding.etContact.clearFocus()
        binding.etConfirmpassword.clearFocus()
    }
    private fun setError(editText: EditText?, message: String) {
        editText?.let {
            it.background = ContextCompat.getDrawable(this, R.drawable.background_error)
            it.requestFocus()
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun isValidContact(Contact:String):Boolean
    {
        return Contact.length==10
    }
    private fun isValidEmail(email:String):Boolean
    {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
    private fun isValidPassword(password:String) : Boolean
    {
        return Pattern.compile(REGEX).matcher(password).matches()
    }
    private fun isValidConfirmpassword(Confirmpassword:String):Boolean
    {
        return  Pattern.compile(REGEX).matcher(Confirmpassword).matches()
    }
}