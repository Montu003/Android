package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityProfileBinding
import com.example.vegi.fragment.ProfileFragment
import com.example.vegi.model.MyDelivery
import com.example.vegi.model.Profile

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding:ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_profile)

        // data get Profile Fragment
        var data = intent.getParcelableExtra<Profile>("data")
        Log.e("TAG", "onCreate:$data ",)
        data?.let {
            binding.moName.setText(it.name)
            binding.moEmail.setText(it.email)
        }

        binding.ivCancel.setOnClickListener {
            finish()
        }

    }
}