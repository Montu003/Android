package com.example.allproject.sharePref

import android.content.Context
import android.content.SharedPreferences

class PrefManager(var context: Context) {

    val PREF_NAME = "my_pref"
    val KEY_STATUS = "isLogin"
    val KEY_INTRO = "isIntro"

    var sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE)
    var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun setLoginStatus(stutus:Boolean){
        editor.putBoolean(KEY_STATUS,stutus)
        editor.commit()
    }

    fun setIntroStatus(stutus: Boolean){
        editor.putBoolean(KEY_INTRO,stutus)
        editor.commit()
    }

    fun getLoginStatus():Boolean{
        return sharedPreferences.getBoolean(KEY_STATUS,false)
    }

    fun getIntroStatus():Boolean{
        return sharedPreferences.getBoolean(KEY_INTRO,false)
    }

}