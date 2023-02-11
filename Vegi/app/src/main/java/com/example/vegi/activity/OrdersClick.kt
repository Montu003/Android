package com.example.vegi.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.databinding.ActivityOrdersClickBinding
import com.example.vegi.fragment.FirstFragment
import com.example.vegi.fragment.SecondFragment
import com.example.vegi.model.Diolog
import com.example.vegi.model.OrderListModel

class OrdersClick : AppCompatActivity() {
//tablayout
    //viewpager
    private lateinit var binding: ActivityOrdersClickBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_orders_click)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

       var data = intent.getParcelableExtra<OrderListModel>("data")
       // var pos = intent.getIntExtra("pos",0)

        binding.btnSummary.setOnClickListener {

            binding.btnSummary.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.btnSummary.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.btnItems.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.btnItems.setTextColor(this.getResources().getColorStateList(R.color.black))

            var bundle = Bundle()
            var firstFrag = FirstFragment()
            bundle.putParcelable("data",data)
            firstFrag.arguments = bundle
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment,firstFrag)
                .commit()
        }

        binding.btnItems.setOnClickListener {

            binding.btnItems.setBackgroundTintList(this.getResources().getColorStateList(R.color.orange))
            binding.btnSummary.setBackgroundTintList(this.getResources().getColorStateList(R.color.gray))
            binding.btnItems.setTextColor(this.getResources().getColorStateList(R.color.white))
            binding.btnSummary.setTextColor(this.getResources().getColorStateList(R.color.black))

            supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment,SecondFragment())
                .commit()
        }

        binding.btnSummary.performClick()
    }
}