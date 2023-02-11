package com.example.localhost

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.localhost.databinding.ActivityHomeBinding
import com.example.localhost.databinding.ActivityMainBinding
import com.example.localhost.pref.PrefManager

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var manager = PrefManager(this)

        manager.getUser()?.let {

            binding.result.text = """
                
                id : ${it.id}
                name : ${it.name}
                email : ${it.email}
                contact : ${it.contact}
            """.trimIndent()
        }
    }
}