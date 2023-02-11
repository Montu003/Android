package com.example.nestedrecyclerview.model

data class Category(
    var id:Int,
    var title:String,
    var movieList:MutableList<SubCategory>
)
