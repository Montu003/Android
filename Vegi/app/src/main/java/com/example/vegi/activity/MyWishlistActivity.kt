package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityMyWishlistBinding

class MyWishlistActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMyWishlistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_my_wishlist)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }
    }
}