package com.example.vegiapp.model


import com.google.gson.annotations.SerializedName

data class Register(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
) {
    data class Data(
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("device_token")
        val deviceToken: String,
        @SerializedName("device_type")
        val deviceType: Int,
        @SerializedName("email")
        val email: String,
        @SerializedName("firstname")
        val firstname: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("identity")
        val identity: String,
        @SerializedName("image")
        val image: String,
        @SerializedName("lastname")
        val lastname: Any,
        @SerializedName("login_type")
        val loginType: String,
        @SerializedName("updated_at")
        val updatedAt: String
    )
}