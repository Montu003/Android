package com.example.api.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient {

    companion object {
        private var retrofit:Retrofit?=null
        fun init(): ApiService {
            if (retrofit==null){

                retrofit = Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

          return retrofit!!.create(ApiService::class.java)
        }

    }
}