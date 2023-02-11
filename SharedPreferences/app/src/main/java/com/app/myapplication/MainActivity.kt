package com.app.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.app.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        sharedPreferences = getSharedPreferences(Const.SHARE, MODE_PRIVATE)

        if (sharedPreferences.getBoolean(Const.IS_LOGGEDIN,false))
        {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
        }

        binding.btnSave.setOnClickListener {

            val name = binding.etName.text.toString().trim()
            val email = binding.etEmail.text.toString().trim()

            val contact = if (binding.etContact.text.toString().trim()
                    .isEmpty()
            ) 0 else binding.etContact.text.toString().trim().toInt()

            val age = if (binding.etAge.text.toString().trim()
                    .isEmpty()
            ) 0 else binding.etAge.text.toString().trim().toInt()

            val city = binding.etCity.text.toString().trim()

            val pincode = if (binding.etPincode.text.toString().trim()
                    .isEmpty()
            ) 0 else binding.etPincode.text.toString().trim().toInt()

            saveRecord(name, email, contact, age, city, pincode)
        }
    }

    private fun saveRecord(
        name: String,
        email: String,
        contact: Int,
        age: Int,
        city: String,
        pincode: Int,
    ) {
        val editor = sharedPreferences.edit()

        editor.putString(Const.NAME,name)
        editor.putString(Const.EMAIL, email)
        editor.putString(Const.CITY, city)
        editor.putInt(Const.CONTACT, contact)
        editor.putInt(Const.AGE, age)
        editor.putInt(Const.PINCODE, pincode)
        editor.putBoolean(Const.IS_LOGGEDIN, true)
        editor.apply()

        Toast.makeText(applicationContext, "Record saved", Toast.LENGTH_SHORT).show()
    }
}