package com.example.list.di

import com.example.list.utils.Constant.Companion.TOKEN
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor():Interceptor {

//    @Inject
//    lateinit var myPref: PrefManager

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
       // val token = tokenManager.getToken()
        request.addHeader("Authorization", "Bearer $TOKEN").addHeader("unique-key","dev123")
        return chain.proceed(request.build())
    }

}