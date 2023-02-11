package com.app.myapplication

import android.content.Context
import android.content.SharedPreferences

class SessionManager(context: Context) {

    private var pref: SharedPreferences =
        context.getSharedPreferences(BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE)

    var editor = pref.edit()

    fun getBooleanValue(key: String?): Boolean {
        return pref.getBoolean(key, false)
    }

    fun getStringValue(key: String?): String? {
        return pref.getString(key,null)
    }

    fun getIntValue(key: String?): Int {
        return pref.getInt(key,0)
    }

    fun saveBooleanValue(Key:String,value:Boolean){
        editor.putBoolean(Key,value)
        editor.apply()
    }

    fun saveStringValue(Key:String,value:String){
        editor.putString(Key,value)
        editor.apply()
    }

    fun saveIntValue(Key:String,value:Int){
        editor.putInt(Key,value)
        editor.apply()
    }

}