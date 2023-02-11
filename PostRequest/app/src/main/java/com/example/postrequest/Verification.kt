package com.example.postrequest

import ApiClient
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.postrequest.databinding.ActivityVerificationBinding
import com.example.postrequest.model.Account
import com.example.postrequest.network.callback.RegisterResponse
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Verification : AppCompatActivity() {

    private lateinit var binding: ActivityVerificationBinding
    private  var account: Account? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVerificationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        account = intent.getParcelableExtra<Account>("ACCOUNT")

        if(account!=null){
            binding.etEmail.setText(account!!.email)
        }

        binding.btnVerify.setOnClickListener {

            var email = binding.etEmail.text.toString().trim()
            var otp = binding.etPin.text.toString().trim()

            verifyEmail(email,otp)
        }
    }

    private fun verifyEmail(email: String, otp: String) {
        var json = JsonObject()
        json.addProperty("email",email)
        json.addProperty("email_otp",otp)

        ApiClient.init().verifyEmail(json).enqueue(object : Callback<RegisterResponse>{
            override fun onResponse(
                call: Call<RegisterResponse>,
                response: Response<RegisterResponse>
            ) {
                if (response.isSuccessful){

                    var res = response.body()

                    res?.let {

                        if (it.status){

                            startActivity(Intent(applicationContext,HomeActivity::class.java))
                        }

                        Toast.makeText(applicationContext, "${it.message}", Toast.LENGTH_SHORT).show()
                    }
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
            }
        })
    }
}