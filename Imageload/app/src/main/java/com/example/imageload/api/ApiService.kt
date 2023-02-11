package com.example.imageload.api

import com.example.imageload.model.homepage.HomePage
import io.reactivex.Single
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST(Const.HOME_PAGE)
    fun registerUser(
        @Header(Const.APIKEY) apiKey: String?,
    ): Single<HomePage?>?
}