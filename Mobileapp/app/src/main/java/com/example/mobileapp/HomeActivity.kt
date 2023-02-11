package com.example.customview47

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.mobileapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    //var title: String
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //setContentView(R.layout.activity_home)

        initview()
    }

    fun initview(){

        let{
            var title=intent.getStringExtra("title")
            //var rating=intent.getStringExtra("rating")
            var img=intent.getStringExtra("img")
            var mrp=intent.getStringExtra("mrp")

            binding.tvTitle.text=title.toString()
            binding.tvMrp.text=mrp.toString()
            //binding.tvRating.rating=rating!!.toFloat()

           // binding.ivMontu.setImageResource(img!!.toInt())
        }
        val bundle: Bundle? =intent.extras
        val resId: Int = bundle!!.getInt("img")
        binding.ivMontu.setImageResource(resId)


        var rating = bundle!!.getFloat("rating")
        binding.tvRating.rating = rating.toString().toFloat()

        var mrp = bundle!!.getInt("mrp")
        binding.tvMrp.text = mrp.toString()

        var color = bundle!!.getString("color")
        binding.tvColor.text = color.toString()
    }
}