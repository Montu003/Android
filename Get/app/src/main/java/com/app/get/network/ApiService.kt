package com.app.get.network


import com.app.get.model.DataRespone
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?page=2")
    fun getuserList(): Call<DataRespone>
}