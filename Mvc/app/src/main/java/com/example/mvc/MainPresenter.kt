package com.app.mvppatternandroid.activities.userlist

import android.util.Log
import com.app.mvppatternandroid.network.ApiClient
import com.app.mvppatternandroid.network.callback.CallbackResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainView) {

    fun loadUserList() {

        view.showProgress()

        var callback = ApiClient.init().getUserList(1)

        callback.enqueue(object: Callback<CallbackResponse> {
            override fun onResponse(
                call: Call<CallbackResponse>,
                response: Response<CallbackResponse>
            ) {

                view.hideProgress()

                if(response.isSuccessful){
                    var res = response.body()
                    res?.let {
                      view.success(it.userList)
                    }
                }
            }

            override fun onFailure(call: Call<CallbackResponse>, t: Throwable) {
              //  Log.d("FAILED", "onFailure: ")
                view.hideProgress()
                view.failure("Something went wrong")
            }

        })

    }

}