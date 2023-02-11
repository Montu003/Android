package com.example.localhost.network.callback

import com.example.localhost.model.User
import com.google.gson.annotations.SerializedName

data class RegisterCallbackResponse(
    var status:String,
    @SerializedName("message")
    var msg:String,
    var user:User
)
