package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityClickeventBinding
import com.example.vegi.model.ItemSubCategory

class Clickevent : AppCompatActivity() {

    private lateinit var binding: ActivityClickeventBinding
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_clickevent)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        var  data = intent.getParcelableArrayListExtra<ItemSubCategory>("data")

        //add data count for result
        var add=intent.getIntExtra("Add",0)

        if(add==0){
            binding.btnAdd.text="Add"
        }
        else{
            binding.btnAdd.text=add.toString()
        }

        binding.ivIcon.setImageResource(data?.get(0)!!.image)
       // binding.tvKg.text=data.get(0).price
        binding.tvtitle.text=data.get(0).title

        binding.btnFav.setOnClickListener {

            if (index==0){
                binding.ivDil.setImageResource(R.drawable.ic_favorite_like)
                binding.tvAdditem.text = "remove"
                index =1
            }else {
                index =0
                binding.ivDil.setImageResource(R.drawable.ic_baseline_favorite_border_24)
               // binding.ivDil.visibility = View.VISIBLE
                binding.tvAdditem.text = "Add To Wishlist"
            }
        }
        binding.btnAdd.setOnClickListener {

            if (binding.btnAdd.visibility == View.VISIBLE) {
                binding.btnAdd.visibility = View.GONE
                binding.btnAdddata.visibility = View.VISIBLE
            }
        }

        var count = 1
        binding.ivMinus.setOnClickListener {

            if (1 < count) {
                count--
                binding.tvQty.text = count.toString()
                Log.d("TAG", "onCreateView: " + count)
            } else {
                if (binding.btnAdddata.visibility == View.VISIBLE) {
                    binding.btnAdddata.visibility = View.GONE
                    binding.btnAdd.visibility = View.VISIBLE
                }
            }
        }

        binding.btAddition.setOnClickListener {

            var data = intent.getStringArrayExtra("Add")
            binding.btnAdd.text = data.toString()

            if (count < 7) {
                Log.d("TAG", "onCreateView: " + count)
                count++
                binding.tvQty.text = count.toString()
            }
        }
    }
}