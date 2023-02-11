package com.app.mvppatternandroid.network.callback

import com.app.retrofitandroid.model.Support
import com.app.retrofitandroid.model.User
import com.google.gson.annotations.SerializedName

data class CallbackResponse(
    var page:Int,
    @SerializedName("per_page")
    var perPage:Int,
    var total:Int,
    @SerializedName("total_pages")
    var totalPage:Int,
    @SerializedName("data")
    var userList: ArrayList<User>,
    var support: Support
)
