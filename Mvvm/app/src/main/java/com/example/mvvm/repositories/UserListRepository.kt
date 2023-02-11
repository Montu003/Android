package com.example.mvvm.repositories

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.app.retrofitandroid.model.User
import com.app.retrofitandroid.network.ApiClient
import com.app.retrofitandroid.network.callback.CallbackResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object UserListRepository {

    private var liveData = MutableLiveData<List<User>>()
    private var isLoading = MutableLiveData<Boolean>()

    fun loadUserList(): MutableLiveData<List<User>>
    {
        isLoading.value = true
        var callback = ApiClient.init().getUserList()

        callback.enqueue(object : Callback<CallbackResponse> {
            override fun onResponse(
                call: Call<CallbackResponse>,
                response: Response<CallbackResponse>
            ) {
                isLoading.value = false
                if (response.isSuccessful) {

                    response.body()?.let {
                        liveData.value = it.userList
                    }
                }
            }
            override fun onFailure(call: Call<CallbackResponse>, t: Throwable) {
                Log.d("FAILED", "onFailure: ")
                liveData.value = mutableListOf()
                isLoading.value = false
            }
        })
        return liveData
    }

    fun getLoadingUpdate():MutableLiveData<Boolean>{
        return isLoading
    }
}