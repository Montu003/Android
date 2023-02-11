package com.app.retrofitandroid.network

import com.app.retrofitandroid.network.callback.CallbackResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users?page=1")
    fun getUserList() : Call<CallbackResponse>

}