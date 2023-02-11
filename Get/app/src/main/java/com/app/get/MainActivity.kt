package com.app.get

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.get.adapter.RecyclerAdapter
import com.app.get.databinding.ActivityMainBinding
import com.app.get.model.DataRespone
import com.app.get.model.User
import com.app.get.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    private var userList = mutableListOf<User>()
    private lateinit var retrofit: Retrofit
    private lateinit var service: ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service =retrofit.create(ApiService::class.java)

        adapter = RecyclerAdapter(this,userList)

        binding.rvRecycler.adapter = adapter

        var manager = LinearLayoutManager(applicationContext)
        binding.rvRecycler.layoutManager = manager

        getUserList()

    }

    private fun getUserList() {

        var res : Call<DataRespone> = service.getuserList()

        res.enqueue(object : Callback<DataRespone>{
            override fun onResponse(call: Call<DataRespone>, response: Response<DataRespone>) {

                if (response.isSuccessful){

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