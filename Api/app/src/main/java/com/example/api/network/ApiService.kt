package com.example.api.network

import com.example.api.model.DataResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUserList(@Query("page")page:Int) : Call<DataResponse>

    @GET("")
    fun getCountryList()
}