package com.app.storageoptionandroid

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.storageoption.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var age = if (binding.etAge.text.toString().trim()
                    .isEmpty()) 0 else binding.etAge.text.toString().trim().toInt()

            saveRecord(name, email, age)
        }
        binding.btnRead.setOnClickListener {
            readRecord()
        }
    }

    private fun readRecord() {

        var preference:SharedPreferences = getSharedPreferences("tops", MODE_PRIVATE)
        var name = preference.getString("NAME", "")     // 2nd param = default value
        var email = preference.getString("EMAIL", "")     // 2nd param = default value
        var age = preference.getInt("AGE", 0)

        binding.tvResult.text = """
            name : $name
            email : $email 
            age : $age
        """.trimIndent()
    }
    private fun saveRecord(name: String, email: String, age: Int) {

        var preference:SharedPreferences = getSharedPreferences("tops", MODE_PRIVATE)
        var editor:SharedPreferences.Editor = preference.edit()
        editor.putString("NAME", name)
        editor.putString("EMAIL", email)
        editor.putInt("AGE", age)
        editor.commit()

        Toast.makeText(applicationContext, "Record saved", Toast.LENGTH_SHORT).show()

    }
}