package com.example.vegiapp.model

import com.google.gson.annotations.SerializedName

data class HomePage(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
) {
    data class Data(
        @SerializedName("banner")
        val banner: List<Banner>,
        @SerializedName("category")
        val category: List<Category>,
        @SerializedName("categoryWithProduct")
        val categoryWithProduct: List<CategoryWithProduct>,
        @SerializedName("reviews")
        val reviews: List<Review>,
        @SerializedName("settingData")
        val settingData: SettingData
    ) {
        data class Banner(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("updated_at")
            val updatedAt: String
        )

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

        data class CategoryWithProduct(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("image")
            val image: String,
            @SerializedName("products")
            val products: List<Product>,
            @SerializedName("title")
            val title: String,
            @SerializedName("updated_at")
            val updatedAt: String
        ) {
            data class Product(
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

        data class Review(
            @SerializedName("created_at")
            val createdAt: String,
            @SerializedName("feacherd")
            val feacherd: Int,
            @SerializedName("id")
            val id: Int,
            @SerializedName("order_id")
            val orderId: String,
            @SerializedName("rating")
            val rating: Int,
            @SerializedName("review")
            val review: String,
            @SerializedName("updated_at")
            val updatedAt: String,
            @SerializedName("user")
            val user: User,
            @SerializedName("user_id")
            val userId: Int
        ) {
            data class User(
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
                val lastname: String,
                @SerializedName("login_type")
                val loginType: String,
                @SerializedName("updated_at")
                val updatedAt: String
            )
        }

        data class SettingData(
            @SerializedName("about")
            val about: String,
            @SerializedName("app_name")
            val appName: String,
            @SerializedName("appstore")
            val appstore: String,
            @SerializedName("contact")
            val contact: String,
            @SerializedName("created_at")
            val createdAt: Any,
            @SerializedName("currencies")
            val currencies: String,
            @SerializedName("email")
            val email: String,
            @SerializedName("facebook")
            val facebook: String,
            @SerializedName("id")
            val id: Int,
            @SerializedName("instagram")
            val instagram: String,
            @SerializedName("linkedin")
            val linkedin: String,
            @SerializedName("long_des")
            val longDes: String,
            @SerializedName("number")
            val number: String,
            @SerializedName("playstore")
            val playstore: String,
            @SerializedName("privacy_policy")
            val privacyPolicy: String,
            @SerializedName("quantity")
            val quantity: Int,
            @SerializedName("shippingcharge")
            val shippingcharge: String,
            @SerializedName("short_des")
            val shortDes: String,
            @SerializedName("slogan")
            val slogan: String,
            @SerializedName("terms")
            val terms: String,
            @SerializedName("twitter")
            val twitter: String,
            @SerializedName("updated_at")
            val updatedAt: String
        )
    }
}