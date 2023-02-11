package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.FirstAdapter
import com.example.vegi.databinding.ActivityFirstBinding
import com.example.vegi.model.First

class FirstActivity : AppCompatActivity() {

    lateinit var binding: ActivityFirstBinding
    var first = ArrayList<First>()
    private var madapter:FirstAdapter = FirstAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_first)

      //  var data = intent.getParcelableArrayListExtra<First>("data")

        var data = intent.getStringExtra("title")
        binding.btnTitle.text = data

       var dataTitl=intent.getStringExtra("title")
        binding.btnTitle.text=dataTitl

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }
       // madapter = FirstAdapter(this)
        binding.adapter = madapter
        binding.rcOutput.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rcOutput.adapter = madapter

        //val suData = ArrayList<First>()
        first.add(First(1, R.drawable.image_22,"Atta","10.0/Gram","₹25"))
        first.add(First(2, R.drawable.image_12,"Potato","1.0/Kg","₹26"))
        first.add(First(3, R.drawable.image_22,"Atta","11.0/Gram","₹27"))
        first.add(First(4, R.drawable.image_12,"Potato","15.0/Gram","₹28"))
        first.add(First(5, R.drawable.image_22,"Atta","12.0/Gram","₹29"))
        first.add(First(6, R.drawable.image_12,"Potato","5.0/Gram","₹30"))
        first.add(First(7, R.drawable.image_22,"Atta","2.0/Kg","₹31"))
        first.add(First(8, R.drawable.image_12,"Potato","1.0/Kg","₹32"))
        first.add(First(9, R.drawable.image_22,"Atta","10.0/Gram","₹33"))
        first.add(First(10, R.drawable.image_12,"Potato","1.0/Kg","₹34"))
        first.add(First(11, R.drawable.image_22,"Atta","15.0/Gram","₹35"))
        first.add(First(12, R.drawable.image_12,"Potato","1.0/Kg","₹36"))

        madapter.seData(first)

    }
}