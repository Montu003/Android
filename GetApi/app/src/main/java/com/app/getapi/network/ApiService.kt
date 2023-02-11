package com.app.getapi.network

import com.app.getapi.model.DataRespone
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?page=2")
    fun getuserList() :Call<DataRespone>

}