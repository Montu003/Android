package com.example.vegi.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vegi.R
import com.example.vegi.adapter.OrderAdapter
import com.example.vegi.databinding.ActivityOrderDetailsBinding
import com.example.vegi.model.OrderListModel

class OrderDetails : AppCompatActivity() {

    private lateinit var binding: ActivityOrderDetailsBinding
    private lateinit var adapter: OrderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order_details)

        binding.btnImage.setOnClickListener {
            onBackPressed()
        }

        recyclerInit()

//        binding.btnCancel.setOnClickListener {
//
//            if (index==0){
//                binding.btnCancel.text = "progressing"
//                index =1
//            }else {
//                index =0
//                binding.btnCancel.text = "cancelled"
//            }
//        }
//
//        binding.btnDetails.setOnClickListener {
//            val intent = Intent(this,OrdersClick::class.java)
//            startActivity(intent)
//        }
    }

    private fun recyclerInit() {

        adapter = OrderAdapter(arrayListOf())
        binding.adapter = adapter

        var list = arrayListOf<OrderListModel>()
        list.add(OrderListModel("VEGI12345678", "1", "CANCELLED", "₹51", "27-sep-2022"))
        list.add(OrderListModel("VEGI87654321", "2", "CONFIRMED", "₹51", "23-sep-2022"))
        list.add(OrderListModel("VEGI78654329", "1", "CANCELLED", "₹51", "24-sep-2022"))
        list.add(OrderListModel("VEGI98751622", "1", "CANCELLED", "₹53", "27-sep-2022"))
        list.add(OrderListModel("VEGI12345678", "2", "CONFIRMED", "₹51", "27-sep-2022"))
        list.add(OrderListModel("VEGI65412378", "1", "CANCELLED", "₹52", "25-sep-2022"))
        list.add(OrderListModel("VEGI76548921", "1", "CONFIRMED", "₹51", "27-sep-2022"))
        adapter.filterList(list)
        binding.rcvOrderdetails.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        binding.rcvOrderdetails.adapter = adapter

//       var intent = Intent(this, OrdersClick::class.java)
//       intent.putParcelableArrayListExtra("data", list)
//       intent.putExtra("title",title)
//       startActivity(intent)

        itemClickeEvent()
    }

    private fun itemClickeEvent() {
        adapter.onClick = { data, pos ->
            var intent = Intent(this, OrdersClick::class.java)
            intent.putExtra("data", data)
            intent.putExtra("pos", pos)
            startActivity(intent)

        }
    }
}