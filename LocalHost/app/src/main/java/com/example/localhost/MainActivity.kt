package com.example.localhost

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.localhost.databinding.ActivityMainBinding
import com.example.localhost.network.callback.RegisterCallbackResponse
import com.example.localhost.pref.PrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onResume() {
        super.onResume()

        if (PrefManager(this).getLoginStatus()){
            startActivity(Intent(applicationContext,HomeActivity::class.java))
            finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnRegister.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var contact = binding.etContact.text.toString().trim()

            createAccount(name,email,contact)
        }
    }

    private fun createAccount(name: String, email: String, contact: String) {

     var Callback:Call<RegisterCallbackResponse> = ApiClient.init().createAccount(1,name,email,contact)
        Callback.enqueue(object : Callback<RegisterCallbackResponse>{
            override fun onResponse(
                call: Call<RegisterCallbackResponse>,
                response: Response<RegisterCallbackResponse>
            ) {
                if (response.isSuccessful){

                    var res = response.body()
                    res?.let {

                        Toast.makeText(applicationContext, it.msg, Toast.LENGTH_SHORT).show()

                        if (it.status == "success"){

                            var manager = PrefManager(applicationContext)
                            manager.setLoginStatus(true)
                            manager.setUser(it.user)

                            startActivity(Intent(applicationContext,HomeActivity::class.java))
                            finish()
                        }
                    }
                }
            }

            override fun onFailure(call: Call<RegisterCallbackResponse>, t: Throwable) {
                Log.d("TAG", "onFailure: ")
            }
        })
    }
}