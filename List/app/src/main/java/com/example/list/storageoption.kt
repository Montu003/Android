package com.example.list

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.list.databinding.ActivityStorageoptionBinding

class storageoption : AppCompatActivity() {

    private lateinit var binding: ActivityStorageoptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorageoptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {

            var name = binding.etName.text.toString().trim()
            var email = binding.etEmail.text.toString().trim()
            var age = if (binding.etAge.text.toString().trim().isEmpty())
                0 else binding.etAge.text.toString().trim().toInt()

            saveRecord(name, email, age)
        }
        binding.btnRead.setOnClickListener {
            readRecord()
        }
    }

    private fun readRecord() {

        var preferences = getSharedPreferences("tops", MODE_PRIVATE)

        var name = preferences.getString("NAME", "")
        var email = preferences.getString("EMAIL", "")
        var age = preferences.getInt("AGE", 0)

        binding.tvResult.text = """
            name : $name
            email : $email
            age : $age
        """.trimIndent()
    }

    private fun saveRecord(name: String, email: String, age: Int) {

        var preferences = getSharedPreferences("tops", MODE_PRIVATE)
        var editor = preferences.edit()
        editor.putString("NAME", name)
        editor.putString("EMAIL", email)
        editor.putInt("AGE", age)
        editor.commit()

        Toast.makeText(applicationContext, "Record saved", Toast.LENGTH_SHORT).show()
    }
}