package com.app.retrofitandroid.network

import com.app.retrofitandroid.utils.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {

    companion object{

        private var retrofit:Retrofit? = null

        fun init() :ApiService
        {
            if(retrofit==null)
            {
                retrofit = Retrofit.Builder()
                    .baseUrl(Const.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }

            return retrofit!!.create(ApiService::class.java)

        }

    }

}