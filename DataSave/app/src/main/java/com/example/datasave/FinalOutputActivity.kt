package com.example.datasave

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datasave.databinding.ActivityFinalOutputBinding
import com.example.xampplocal.model.User

class FinalOutputActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFinalOutputBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalOutputBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var user = intent.getParcelableExtra<User>("USER")


        user?.let {
            binding.tvName.setText(it.name)
            binding.tvEmail.setText(it.email)
        }
        binding.ivBack.setOnClickListener {
            finish()
        }

    }
}