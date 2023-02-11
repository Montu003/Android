package com.example.list

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.list.databinding.ActivityShareBinding

class shareActivity : AppCompatActivity() {

    private lateinit var binding: ActivityShareBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShareBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var age = if (binding.etAge.text.toString().trim()
                    .isEmpty()
            ) 0 else binding.etAge.text.toString().trim().toInt()

            saveRecord(name,email,age)
        }
        binding.btnRead.setOnClickListener {
            readRecord()
        }
    }

    private fun readRecord() {

        var sharedPreferences:SharedPreferences = getSharedPreferences("khodal", MODE_PRIVATE)

        var name = sharedPreferences.getString("NAME","")
        var email = sharedPreferences.getString("EMAIL","")
        var age = sharedPreferences.getInt("AGE",0)

        binding.ivResult.text = """
            name : $name
            email : $email
            age : $age
        """.trimIndent()
    }

    private fun saveRecord(name: String, email: String, age: Int) {

        var sharedPreferences : SharedPreferences = getSharedPreferences("khodal", MODE_PRIVATE)

        var editor = sharedPreferences.edit()

        editor.putString("NAME",name)
        editor.putString("EMAIL",email)
        editor.putInt("AGE",age)
        editor.commit()
    }
}