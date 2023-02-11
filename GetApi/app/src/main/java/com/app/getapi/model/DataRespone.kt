package com.app.getapi.model

import com.google.gson.annotations.SerializedName

data class DataRespone(

    var page:Int,
    @SerializedName("per_page")
    var parPage:Int,
    var total:Int,
    @SerializedName("total_pages")
    var totalPage:Int,
    var support: Support,
    var userList: MutableList<User>
)
