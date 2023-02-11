package com.example.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.jsonparsingandroid.adapter.RecyclerUserAdapter
import com.example.api.databinding.ActivityMainBinding
import com.example.api.model.DataResponse
import com.example.api.model.User
import com.example.api.network.ApiClient
import com.example.api.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var userList = mutableListOf<User>()
    private lateinit var mAdapter: RecyclerUserAdapter
    /*  private lateinit var service:ApiService
      private lateinit var retrofit: Retrofit*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // prepareData()

        /* retrofit = Retrofit.Builder()
             .baseUrl("https://reqres.in/api/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()

         service = retrofit.create(ApiService::class.java)*/

        mAdapter = RecyclerUserAdapter(this, userList)
        binding.recyclerItem.layoutManager = LinearLayoutManager(this)
        binding.recyclerItem.adapter = mAdapter

        getUserList()
    }

    private fun getUserList() {

        binding.progressCircular.visibility = View.VISIBLE

        var request: Call<DataResponse> = ApiClient.init().getUserList(1)

        request.enqueue(object : Callback<DataResponse> {
            override fun onResponse(call: Call<DataResponse>, response: Response<DataResponse>) {
                binding.progressCircular.visibility = View.GONE
                if (response.isSuccessful) {
                    var res = response.body()

                    res?.let {

                        mAdapter.setItem(it.userList)
                    }
                }
            }

            override fun onFailure(call: Call<DataResponse>, t: Throwable) {

                binding.progressCircular.visibility = View.GONE

            }

        })
    }

    /*private fun prepareData() {
        userList.add(User(1,"khodal@gmail.com","khodal","Avaiya"))
        userList.add(User(2,"montu@gmail.com","montu","Avaiya"))
        userList.add(User(3,"Romil@gmail.com","Romil","Avaiya"))
        userList.add(User(4,"Dhruv@gmail.com","Dhruv","Avaiya"))
        userList.add(User(5,"Jeel@gmail.com","Jeel","Avaiya"))
    }*/
}