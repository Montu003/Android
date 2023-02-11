package com.example.appvegi.model


data class cetgoriesModel(
    var id: Int,
    var name: String,
    var title: String,
    var listSubcat: MutableList<subCatModel>
) {

}