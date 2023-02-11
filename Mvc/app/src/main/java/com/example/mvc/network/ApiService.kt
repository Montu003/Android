package com.app.mvppatternandroid.network

import com.app.mvppatternandroid.network.callback.CallbackResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUserList(@Query ("page") page:Int) : Call<CallbackResponse>

}