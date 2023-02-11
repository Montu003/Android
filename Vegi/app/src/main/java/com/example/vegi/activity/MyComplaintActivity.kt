package com.example.vegi.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.graphics.toColor
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityMyComplaintBinding
import com.example.vegi.fragment.ComplainFragment
import com.example.vegi.fragment.ComplaintFragment
import com.example.vegi.fragment.FirstFragment
import com.example.vegi.fragment.SecondFragment

class MyComplaintActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyComplaintBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_my_complaint)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        binding.btnSummary.setOnClickListener {


            binding.btnSummary.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.btnSummary.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.btnItems.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.btnItems.setTextColor(this.getResources().getColorStateList(R.color.black))

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, ComplaintFragment())
                .commit()
        }

        binding.btnItems.setOnClickListener {


            binding.btnItems.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.btnSummary.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.btnItems.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.btnSummary.setTextColor(this.getResources().getColorStateList(R.color.black))

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment, ComplainFragment())
                .commit()
        }

        binding.btnSummary.performClick()
    }
}