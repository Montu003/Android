package com.app.mvppatternandroid.activities.userlist

import com.app.retrofitandroid.model.User

interface MainView {
    fun success(userList:List<User>)
    fun failure(message:String)
    fun showProgress()
    fun hideProgress()
}