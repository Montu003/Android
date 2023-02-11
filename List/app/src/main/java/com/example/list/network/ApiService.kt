package com.example.list.network

import com.example.list.model.CategoryResponse
import com.example.list.utils.Resource
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("User/getProfileCategoryList")
    suspend fun getCategoryData():Response<CategoryResponse>

}