package com.gautam.validatonformgrewon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gautam.validatonformgrewon.adapter.ListRecyclerAdepter
import com.gautam.validatonformgrewon.databinding.ActivityDetailBinding
import com.gautam.validatonformgrewon.databinding.ToastRecyclerBinding
import com.gautam.validatonformgrewon.modal.ListRecyclerBurgurKing
import com.gautam.validatonformgrewon.utilslist.UtilList
import com.google.android.material.snackbar.Snackbar
import com.kishandonga.csbx.CustomSnackbar

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding
    lateinit var adepter: ListRecyclerAdepter
    lateinit var notification: MyFaireBase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var messagess = intent.getStringExtra("title")
        var description = intent.getStringExtra("messagebody")
        if (messagess != null) {
            Toast.makeText(this, messagess, Toast.LENGTH_SHORT).show()
        }
        val dataList = UtilList.getMenuList(this)
        val extra = ListRecyclerBurgurKing(

            rowimage = R.drawable.burgur1
        )
        val newlist = ArrayList<ListRecyclerBurgurKing>()
        for ((i, data) in dataList.withIndex()) {
            if (i % 2 == 0 && i != 0) {
                newlist.add(extra)
            }
            newlist.add(data)
        }
        adepter = ListRecyclerAdepter(this, newlist)
        binding.rvMenurecycler.layoutManager = LinearLayoutManager(this)
        binding.rvMenurecycler.adapter = adepter

        adepter.addAdition(object : ListRecyclerAdepter.TotalAmount {
            override fun addamount(arraylist: ArrayList<ListRecyclerBurgurKing>, view: View) {
                var itemCount = 0
                var totalAmount = 0.0
                for (data in arraylist) {
                    itemCount += data.quantity
                    totalAmount += data.price.toDouble().times(data.quantity)
                }

                val layout = ToastRecyclerBinding.inflate(layoutInflater)
                layout.tvTotal.text = totalAmount.toString()
                layout.tvItem.text = itemCount.toString()
                CustomSnackbar(this@DetailActivity).show {
                    customView(layout.root)
                    duration(Snackbar.LENGTH_INDEFINITE)
                }
            }

            override fun removeamount(arraylist: ArrayList<ListRecyclerBurgurKing>, view: View) {
                var itemCount = 0
                var totalAmount = 0.0
                for (data in arraylist) {
                    itemCount += data.quantity
                    totalAmount += data.price.toDouble().times(data.quantity)
                }
                val layout = ToastRecyclerBinding.inflate(layoutInflater)
                layout.tvTotal.text = totalAmount.toString()
                layout.tvItem.text = itemCount.toString()
                CustomSnackbar(this@DetailActivity).show {
                    customView(layout.root)
                    duration(Snackbar.LENGTH_SHORT)
                }
            }
        })
    }
}
