package com.example.on

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.on.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toggleButton.setOnClickListener {

            if (binding.toggleButton.text.toString() == "ON") {

                binding.imageView.setImageResource(R.drawable.image_52)
                Toast.makeText(this, "bulbOn", Toast.LENGTH_SHORT).show()
            } else {
                binding.imageView.setImageResource(R.drawable.image_51)
                Toast.makeText(this, "bulbOff", Toast.LENGTH_SHORT).show()
            }
        }

    }
}