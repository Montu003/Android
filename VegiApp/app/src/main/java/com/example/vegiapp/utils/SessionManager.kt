package com.example.vegiapp.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.vegiapp.api.Const
import com.example.vegiapp.model.Register
import com.google.gson.Gson

class SessionManager(context: Context) {

    val context = context

    private var pref: SharedPreferences? =
        context.getSharedPreferences("vegi", Context.MODE_PRIVATE)

    private var editor: SharedPreferences.Editor? = pref?.edit()

    fun saveIntValue(key: String?, value: Int) {
        editor!!.putInt(key, value)
        editor!!.apply()
    }

    fun saveStringValue(key: String?, value: String) {
        editor!!.putString(key, value)
        editor!!.apply()
    }

    fun getIntValue(key: String?): Int {
        return pref!!.getInt(key, 0)
    }

    fun getStringValue(key: String?): String? {
        return pref!!.getString(key, null)
    }

    fun saveBooleanValue(key: String?, value: Boolean) {
        editor!!.putBoolean(key, value)
        editor!!.apply()
    }

    fun getBooleanValue(key: String?): Boolean {
        return pref!!.getBoolean(key, false)
    }

    fun saveUserData(data: Register.Data?) {
        editor!!.putString(Const.USER_DATA,Gson().toJson(data))
        editor!!.apply()
    }

    fun getuserdata() : Register.Data?{
        val string = pref!!.getString(Const.USER_DATA,null)
        if (string==null){
            return null
        }
        else{
            return Gson().fromJson(string,Register.Data::class.java)
        }
    }
}