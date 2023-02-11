package com.example.list.model


import com.google.gson.annotations.SerializedName

data class Profile(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("profile_category_id")
        val profileCategoryId: Int,
        @SerializedName("profile_category_image")
        val profileCategoryImage: String,
        @SerializedName("profile_category_name")
        val profileCategoryName: String
    )
}