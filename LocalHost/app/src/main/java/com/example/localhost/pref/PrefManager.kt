package com.example.localhost.pref

import android.content.Context
import com.example.localhost.model.User
import com.google.gson.Gson

class PrefManager(context: Context) {

    private val PREF_NAME = "student"
    private val LOGIN_STATUS = "login_status"
    private val USER = "user"

    private var sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    private var editor = sharedPreferences.edit()

    fun setLoginStatus(status: Boolean) {

        editor.putBoolean(LOGIN_STATUS, status)
        editor.commit()
    }

    fun setUser(user: User) {

        var gson = Gson()
        var jsonString = gson.toJson(user)

        editor.putString(USER, jsonString)
        editor.commit()
    }

    fun getUser(): User {
        var user: User? = null
        var result = sharedPreferences.getString(USER, "")

        var gson = Gson()
        return gson.fromJson(result, User::class.java)

    }

    fun getLoginStatus() : Boolean
    {
        return sharedPreferences.getBoolean(LOGIN_STATUS,false)
    }
}