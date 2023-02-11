package com.example.app.activitys

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.app.MainActivity
import com.example.app.database.Appdatabase
import com.example.app.fragments.ChatFragment
import com.example.app.shredpref.PrefManagr
import com.example.weddingapp.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    lateinit var db: Appdatabase
    private lateinit var mAuth: FirebaseAuth


    private val REGEX = ("^(?=.*[0-9])"
            + "(?=.*[a-z])(?=.*[A-Z])"
            + "(?=.*[@#$%^&+=])"
            + "(?=\\S+$).{8,20}$")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Appdatabase.getDatabase(this)


        mAuth = FirebaseAuth.getInstance()
        binding.btnSignup.setOnClickListener {

            startActivity(Intent(this, SignupActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {


            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()




            var prefManagr = PrefManagr(this)



            if (!isValidEmail(email)) {
                binding.tvEmail.error = "Enter your email"
            } else if (password.isEmpty()) {
                binding.tvPassword.error = "Enter your password"
            } else {
//                val user = User(
//                    email = email,
//                    password = password
//                )
                mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            prefManagr.setLoginStatus(true)
                            Toast.makeText(this, "Login Successfully", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this, MainActivity::class.java))
                        } else {
                            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show()
                        }
                    }
//                db.userDao.insertRecord(user)
//                Toast.makeText(applicationContext, "data save", Toast.LENGTH_SHORT).show()

            }
        }
    }


    private fun isValidEmail(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }
}