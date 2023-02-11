package com.example.app.shredpref

import android.content.Context
import android.content.SharedPreferences
import com.example.app.database.entity.User
import com.google.gson.Gson

class PrefManagr (var context: Context){


    val PEREF_NAME = "my-pref"
    val KEY_STATUS =  "isLogin"
    val USER =  "user"


    var sharedPreferences:SharedPreferences =  context.getSharedPreferences(PEREF_NAME, Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun  setLoginStatus(status:Boolean){
        editor.putBoolean(KEY_STATUS,status)
        editor.commit()
    }

    fun getLoginStatus():Boolean{
        return sharedPreferences.getBoolean(KEY_STATUS,false)
    }

    fun saveUser(user: User?){
        val gson = Gson()
        val json: String = gson.toJson(user)
        editor.putString(USER, json).apply()
    }

    fun getUser():User?{
        val gson = Gson()
        val json: String? = sharedPreferences.getString(USER, null)
        return gson.fromJson(json, User::class.java)
    }

}