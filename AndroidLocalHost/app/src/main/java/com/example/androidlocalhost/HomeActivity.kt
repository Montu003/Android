package com.example.androidlocalhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.androidlocalhost.databinding.ActivityHomeBinding
import com.example.androidlocalhost.model.User
import com.example.androidlocalhost.network.ApiClient
import com.example.androidlocalhost.network.callback.UserListCallback
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    var userList = mutableListOf<User>()
    lateinit var mAdapter:ArrayAdapter<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ApiClient.init().getUserList(4).enqueue(object : Callback<UserListCallback> {
            override fun onResponse(
                call: Call<UserListCallback>,
                response: Response<UserListCallback>
            ) {

                if (response.isSuccessful){

                    response.body()?.let {
                        mAdapter = ArrayAdapter(applicationContext,android.R.layout.simple_list_item_1,it.userList)
                        binding.listView.adapter = mAdapter
                    }
                }
            }

            override fun onFailure(call: Call<UserListCallback>, t: Throwable) {

            }
        })

    }
}