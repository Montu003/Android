package com.example.vegi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.DeliveryAdapter
import com.example.vegi.databinding.ActivityMyDeliveryAddressBinding
import com.example.vegi.model.MyDelivery

class MyDeliveryAddress : AppCompatActivity() {

    private lateinit var binding: ActivityMyDeliveryAddressBinding
    private lateinit var adapter: DeliveryAdapter

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this, R.layout.activity_my_delivery_address)

        recy()
        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        binding.floatingActionButton.setOnClickListener {

            val intent = Intent(this, formfield::class.java)
            startActivity(intent)
        }
    }

    private fun recy() {
        adapter = DeliveryAdapter(arrayListOf())
        binding.adapter = adapter

        var List = arrayListOf<MyDelivery>()

        List.add(MyDelivery(1,"Khodal","1125 mota varacha surat  " ,"1234567890","1234567890","395006"))
        List.add(MyDelivery(2,"Jeel - CEO","1125 mota varacha surat  ","1234562135","1234567890","123456"))
        List.add(MyDelivery(3,"Dhruv - Flutter","1125 mota varacha surat  ","956328421","1234567890","363636"))
        List.add(MyDelivery(4,"Parth - CEO","1125 mota varacha surat  ","356289141","1264315152","362990"))
        List.add(MyDelivery(5,"Montu - Android","1125 mota varacha surat  ","1234567890","362659441","232363"))
        List.add(MyDelivery(6,"Gaurav Web design","1125 mota varacha surat  ","1234567890","369251415","142536"))
        List.add(MyDelivery(7,"Aniket - Iso","1125 mota varacha surat  ","1234567890","995482149","695623"))
        List.add(MyDelivery(8,"Avadh - Full stack","1125 mota varacha surat  ","235615822","1234567890","362353"))
        List.add(MyDelivery(9,"Neel - Flutter","1125 mota varacha surat  ","1234567890","326116855","363623"))
        List.add(MyDelivery(10,"Romil - flutter","1125 mota varacha surat  ","999464482","326141451","367895"))

        adapter.Delivery(List)
        binding.btnDelivery.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.btnDelivery.adapter = adapter

    }
}