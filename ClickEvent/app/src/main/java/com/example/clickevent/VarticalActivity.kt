package com.example.clickevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.clickevent.databinding.ActivityHomeBinding
import com.example.clickevent.databinding.ActivityRecyclerBinding
import com.example.clickevent.databinding.ActivityVarticalBinding

class VarticalActivity : AppCompatActivity() {

    private lateinit var binding: ActivityVarticalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVarticalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initview()
    }
    fun initview(){
        let{
            var title=intent.getStringExtra("title")
            binding.tvVartitle.text=title.toString()
            var color=intent.getStringExtra("color")
            binding.tvVarcolor.text = color.toString()

        }
        val bundle: Bundle? =intent.extras

        var resId = bundle!!.getInt("image")
        binding.ivMontu.setImageResource(resId)

        var rating = bundle!!.getFloat("rating")
        binding.tvVarrating.rating = rating.toString().toFloat()

        var mrp = bundle!!.getInt("mrp")
        binding.tvVarmrp.text = mrp.toString()
    }
}