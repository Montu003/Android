package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.OutPutAdapter
import com.example.vegi.databinding.ActivityOutPutBinding
import com.example.vegi.model.ItemSubCategory

class OutPutActivity : AppCompatActivity() {

    lateinit var adapter:OutPutAdapter
    lateinit var binding:ActivityOutPutBinding
    //lateinit var list: ArrayList<ItemSubCategory>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_out_put)

        var data = intent.getParcelableArrayListExtra<ItemSubCategory>("data")

        var dataTitle=intent.getStringExtra("title")
        binding.tvTitle.text=dataTitle

        binding.btnBack.setOnClickListener {
            onBackPressed()
        }

        adapter = OutPutAdapter(this,data!!)
        binding.adapter = adapter
        binding.rcvOutput.layoutManager = StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL)
        binding.rcvOutput.adapter = adapter
    }
}

