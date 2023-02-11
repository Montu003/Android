package com.example.apiservicedemo.api

import com.example.apiservicedemo.model.profilecategory.ProfileCategory
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header

interface ApiService{

    @GET(Const.GET_PROFILE_CATEGORY_LIST)
    fun registerUser(
        @Header(Const.AUTHORIZATION) authorization: String?,
        @Header(Const.UNIQUE_KEY) uniqueKey: String?,
    ): Single<ProfileCategory?>?

}