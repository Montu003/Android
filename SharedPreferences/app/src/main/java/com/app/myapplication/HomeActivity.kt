package com.app.myapplication

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.myapplication.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        sharedPreferences = getSharedPreferences(Const.SHARE, MODE_PRIVATE)

//        val sharedPreferences: SharedPreferences = this.getSharedPreferences(
//            BuildConfig.APPLICATION_ID,MODE_PRIVATE
//        )

        binding.tvName.text = sharedPreferences.getString(Const.NAME,"")
        binding.tvEmail.text = sharedPreferences.getString(Const.EMAIL,"")
        binding.tvCity.text = sharedPreferences.getString(Const.CITY,"")
        binding.tvContact.text = sharedPreferences.getInt(Const.CONTACT,0).toString()
        binding.tvAge.text = sharedPreferences.getInt(Const.AGE,0).toString()
        binding.tvPincode.text = sharedPreferences.getInt(Const.PINCODE,0).toString()

    }
}