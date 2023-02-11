package com.example.storage_permission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.storage_permission.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstBinding
    private val REQ_CODE = 100

    val result = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {

            it.data?.let {
                var message = it.getStringExtra("RES")
                binding.tvResult.text = message
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener {

            var message = binding.etMessage.text.toString().trim()

            var intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("MSG", message)
            //startActivity(intent)
            //startActivityForResult(intent,REQ_CODE)
            result.launch(intent)
        }
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE && resultCode == REQ_CODE) {

            data?.let {
                var message = it.getStringExtra("RES")
                binding.tvResult.text = message
            }
        }
    }
}