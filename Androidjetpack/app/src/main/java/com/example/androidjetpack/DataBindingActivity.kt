package com.example.androidjetpack

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import com.example.androidjetpack.databinding.ActivityDataBindingBinding

class DataBindingActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDataBindingBinding

    val tvName:TextView
    get() = findViewById(R.id.tv_name)

    val tvEmail:TextView
    get() = findViewById(R.id.tv_email)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)

        binding.person = Person("avaiya","montu@gmail.com")

//        tvName.text = "Khodal"
//        tvEmail.text = "khodal@gmail.com"

        binding.btnUpdate.setOnClickListener {

            binding.person = Person("montu","montu@gmail.com")

//            tvName.text = person.name
//            tvEmail.text = person.email
        }
    }
}