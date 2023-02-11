package com.example.customview47

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customview47.databinding.ActivityCustomListBinding
import com.example.customview47.databinding.ActivityHomeBinding

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
        var type=intent.getStringExtra("type")
        var time=intent.getStringExtra("time")
        //var img=intent.getStringExtra("img")

          binding.tvTitle.text=title.toString()
          binding.tvType.text=type.toString()
          binding.tvTime.text=time.toString()

          //binding.ivMontu.setImageResource(img!!.toInt())
      }

        val bundle: Bundle? =intent.extras
        val resId: Int = bundle!!.getInt("img")
        binding.ivMontu.setImageResource(resId)



    }
}