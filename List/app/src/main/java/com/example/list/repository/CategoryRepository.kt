package com.example.list.repository

import com.example.list.network.ApiService
import com.example.list.network.safeApiCall
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.concurrent.Flow
import javax.inject.Inject


class CategoryRepository @Inject constructor(private val apiService:ApiService){

    fun getCatData() =  safeApiCall {
       apiService.getCategoryData()
    }.flowOn(Dispatchers.IO)
}