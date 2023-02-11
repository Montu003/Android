package com.gautam.validatonformgrewon.shareprefrence

import android.content.Context
import android.content.SharedPreferences
import com.gautam.validatonformgrewon.modal.GoogleLogin
import com.gautam.validatonformgrewon.modal.RememberMe
import com.gautam.validatonformgrewon.modal.Users
import com.google.gson.Gson

class PrefManager(context: Context) {

    val PEREF_NAME = "my-pref"
    val KEY_LOGIN = "login"
    val KEY_INTRO = "isIntro"
    val KEY_REMEBER_ME = "remember_me"
    val Status = "goole_facebook"

    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences(PEREF_NAME, Context.MODE_PRIVATE)
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()

    fun saveLoginCredentials(user: Users) {
        val credentialToJson = Gson().toJson(user)
        return sharedPreferences.edit().putString(KEY_LOGIN, credentialToJson).apply()
    }

    fun getLoginCredentials(): Users? {
        return Gson().fromJson(sharedPreferences.getString(KEY_LOGIN, ""), Users::class.java)
    }

    fun saveRememberMe(user: RememberMe) {
        editor.putString(KEY_REMEBER_ME, Gson().toJson(user)).apply()
    }

    fun getRememberMe(): RememberMe? {
        return Gson().fromJson(
            sharedPreferences.getString(KEY_REMEBER_ME, ""), RememberMe::class.java
        )
    }

   /* fun setGoogleFacebookLoginStatus(google: GoogleLogin) {
        val credentialToJson = Gson().toJson(google)
        return sharedPreferences.edit().putString(Status, credentialToJson).apply()

    }

    fun getGoogleFacebookLoginStatus(): GoogleLogin {
        return Gson().fromJson(sharedPreferences.getString(Status, ""), GoogleLogin::class.java)
    }*/


    fun clear() {
        editor.remove(KEY_LOGIN).apply()
        editor.remove(Status).apply()
    }

}