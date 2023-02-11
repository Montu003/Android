package com.example.postrequest.model

import com.google.gson.annotations.SerializedName

data class User(
    var id: Int = 0,
    var name: String,
    var email: String,
    var password: String,
    @SerializedName("confirm_password")
    var cPassword: String,
    @SerializedName("country_id")
    var countryCode: String = "101",
    @SerializedName("state_id")
    var stateCode: String = "12",
    @SerializedName("city_id")
    var cityCode: String = "1041"
)
