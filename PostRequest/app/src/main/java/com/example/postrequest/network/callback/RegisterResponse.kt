package com.example.postrequest.network.callback

import com.example.postrequest.model.Account
import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    var status:Boolean,
    @SerializedName("status_code")
    var statusCode:String,
    var message:String,
    @SerializedName("data")
    var account:Account
)
