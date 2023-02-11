package com.example.androidlocalhost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidlocalhost.databinding.ActivityMainBinding
import com.example.androidlocalhost.network.ApiClient
import com.example.androidlocalhost.network.callback.RegisterCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var mobile = binding.etContact.text.toString().trim()

            createAccount(name,email,mobile)
        }
    }

    private fun createAccount(name: String, email: String, mobile: String) {

        ApiClient.init().register(1,name, email, mobile).enqueue(object :
            Callback<RegisterCallback> {
            override fun onResponse(
                call: Call<RegisterCallback>,
                response: Response<RegisterCallback>
            ) {
                if (response.isSuccessful){

                    response.body()?.let {

                        Toast.makeText(applicationContext, it.message, Toast.LENGTH_SHORT).show()

                        if (it.status == "Success" && it.user!=null){

                            startActivity(Intent(applicationContext, HomeActivity::class.java))
                            finishAffinity()

                        }
                    }
                }
            }
            override fun onFailure(call: Call<RegisterCallback>, t: Throwable) {

            }
        })
    }
}