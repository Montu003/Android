package com.example.vegi.model

data class Category(
    var id:Int,
    var title:String,
    var list: ArrayList<Subcategory>
)
