package com.app.retrofitandroid.model

import com.google.gson.annotations.SerializedName

data class User(
    var id:Int,
    var email:String,
    @SerializedName("first_name")
    var firstName:String,
    @SerializedName("last_name")
    var lastName:String,
    @SerializedName("avatar")
    var imageUrl:String
)
