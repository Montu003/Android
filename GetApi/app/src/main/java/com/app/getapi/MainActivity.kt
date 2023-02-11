package com.app.getapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.getapi.adapter.RecyclerAdapter
import com.app.getapi.databinding.ActivityMainBinding
import com.app.getapi.model.DataRespone
import com.app.getapi.model.User
import com.app.getapi.network.ApiService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private  var userList = mutableListOf<User>()
    private lateinit var retrofit: Retrofit
    private lateinit var service: ApiService
    private lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service = retrofit.create(ApiService::class.java)

        adapter = RecyclerAdapter(this,userList)

        binding.rvRecyclerview.adapter = adapter

        var manager = LinearLayoutManager(applicationContext)
        binding.rvRecyclerview.layoutManager = manager

        getUserList()
    }

    private fun getUserList() {

        var res: Call<DataRespone> = service.getuserList()

        res.enqueue(object : Callback<DataRespone>{
            override fun onResponse(call: Call<DataRespone>, response: Response<DataRespone>) {

                if (response.isSuccessful)
                {
                    var khodal = response.body()

                    khodal?.let {
                        adapter.setData(it.userList)
                    }
                }
            }

            override fun onFailure(call: Call<DataRespone>, t: Throwable) {
            }

        })
    }
}