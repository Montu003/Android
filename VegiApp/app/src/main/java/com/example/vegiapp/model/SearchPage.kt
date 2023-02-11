package com.example.vegiapp.model

import com.google.gson.annotations.SerializedName

data class SearchPage(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
) {
    data class Data(
        @SerializedName("category")
        val category: Category,
        @SerializedName("category_id")
        val categoryId: Int,
        @SerializedName("created_at")
        val createdAt: String,
        @SerializedName("description")
        val description: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("images")
        val images: List<Image>,
        @SerializedName("name")
        val name: String,
        @SerializedName("prices")
        val prices: List<Price>,
        @SerializedName("stock")
        val stock: Int,
        @SerializedName("updated_at")
        val updatedAt: String
    ) {
        data class Category(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("title")
            val title: String,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class Image(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("product_id")
            val productId: Int,
            @SerializedName("updated_at")
            val updatedAt: String
        )

        data class Price(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("price")
            val price: String,
            @SerializedName("product_id")
            val productId: Int,
            @SerializedName("sale_price")
            val salePrice: String,
            @SerializedName("unit")
            val unit: String,
            @SerializedName("unit_id")
            val unitId: Int,
            @SerializedName("units")
            val units: Units,
            @SerializedName("updated_at")
            val updatedAt: String
        ) {
            data class Units(
                @SerializedName("created_at")
                val createdAt: String,
                @SerializedName("id")
                val id: Int,
                @SerializedName("title")
                val title: String,
                @SerializedName("updated_at")
                val updatedAt: String
            )
        }
    }
}