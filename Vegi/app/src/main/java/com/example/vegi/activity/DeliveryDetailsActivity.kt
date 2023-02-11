package com.example.vegi.activity

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.DeliverydetailsAdapter
import com.example.vegi.adapter.OrderAdapter
import com.example.vegi.databinding.ActivityDeliveryDetailsBinding
import com.example.vegi.fragment.CartFragment
import com.example.vegi.model.Delivery
import androidx.fragment.app.FragmentTransaction as FragmentTransaction1

class DeliveryDetailsActivity : AppCompatActivity() {

    private lateinit var binding:ActivityDeliveryDetailsBinding
    private lateinit var adapter: DeliverydetailsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_delivery_details)
        recycler()

        //activity to fragment
        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        binding.btnAddress.setOnClickListener {

            val intent = Intent(this,PaymentSummaryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recycler() {
        adapter = DeliverydetailsAdapter(arrayListOf())
        binding.adapter = adapter

        var list1 = arrayListOf<Delivery>()

        list1.add(Delivery(1,"Khodal","1125 mota varacha surat 395006", "1234567890","0987456123"))
        list1.add(Delivery(2,"Jeel - CEO","1125 mota varacha surat 395006", "9874562","1234567890"))
        list1.add(Delivery(3,"Parth - CEO","1125 mota varacha surat 395006", "2351620000141","98745614230"))
        list1.add(Delivery(4,"Dhruv - Flutter ","1125 mota varacha surat 395006", "1234567890","3030251620"))
        list1.add(Delivery(6,"Montu - Android","1125 mota varacha surat 395006", "1234567890","9212897012"))
        list1.add(Delivery(5,"Gaurav - web design","1125 mota varacha surat 395006", "32652365152","9090899057"))
        list1.add(Delivery(7,"Neel - Flutter","1125 mota varacha surat 395006", "1234567890","6363545525"))
        list1.add(Delivery(8,"Aniket - ISO","1125 mota varacha surat 395006", "1234567890","2323636352"))
        list1.add(Delivery(9,"Avadh - Full stack","1125 mota varacha surat 395006", "1234567890","8888899089"))
        list1.add(Delivery(10,"Yash - Android","1125 mota varacha surat 395006", "1234567890","3513738139"))
        list1.add(Delivery(11,"Keval - Android","1125 mota varacha surat 395006", "1234567890","3513738139"))
        list1.add(Delivery(12,"Romil - Flutter","1125 mota varacha surat 395006", "1234567890","3513738139"))
        list1.add(Delivery(15,"Vraj - ISO","1125 mota varacha surat 395006", "1234567890","3513738139"))
        list1.add(Delivery(16,"Maulik - Flutter","1125 mota varacha surat 395006", "1234567890","3513738139"))

        adapter.filter(list1)
        binding.btnList.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        binding.btnList.adapter = adapter

    }
}