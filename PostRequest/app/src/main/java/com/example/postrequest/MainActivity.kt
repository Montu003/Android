package com.example.postrequest

import ApiClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.example.postrequest.databinding.ActivityMainBinding
import com.example.postrequest.model.User
import com.example.postrequest.network.callback.RegisterResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var password = binding.etPassword.text.toString().trim()
            var cPassword = binding.etCPassword.text.toString().trim()

            createAccount(name, email, password, cPassword)
        }
    }

    private fun createAccount(name: String, email: String, password: String, cPassword: String) {

        var user = User(name = name, cPassword = cPassword, password = password, email = email)

        ApiClient.init().register(user).enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful) {
                    Log.d("TAG", "onResponse: ${response.body()}")
                    var res = response.body()

                    res?.let {

                        if (it.status) {

                            var intent = Intent(applicationContext,Verification::class.java)
                            intent.putExtra("ACCOUNT",it.account)
                            startActivity(intent)
                        }

                        Toast.makeText(applicationContext, "${it.status}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: $call")
            }

        })
    }
}