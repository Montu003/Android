package com.example.customview47.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.customview47.HomeActivity
import com.example.mobileapp.databinding.PhoneItemListBinding
import com.example.mobileapp.model.phone

class CustomListAdapter(var context:Context, var phoneList:MutableList<phone>):BaseAdapter() {

    lateinit var binding: PhoneItemListBinding

    override fun getCount(): Int {
        return phoneList.size
    }

    override fun getItem(pos: Int): Any {
        return phoneList[pos]
    }

    override fun getItemId(pos: Int): Long {
        return pos.toLong()
    }

    override fun getView(pos: Int, view: View?, parent: ViewGroup?): View {
        binding = PhoneItemListBinding.inflate(LayoutInflater.from(context),parent,false)

        var person = phoneList[pos]
        binding.tvTitle.text = person.title
        binding.tvRating.rating = person.rating
        binding.tvMrp.text = person.mrp.toString()
        binding.tvColor.text = person.color
        binding.ivMontu.setImageResource(person.image)

        var strTitle= phoneList.get(pos).title
        var strrating= phoneList.get(pos).rating
        var strmrp = phoneList.get(pos).mrp
        var strColor = phoneList.get(pos).color
        var img=phoneList.get(pos).image

        binding.root.setOnClickListener {
            var intent=Intent(context,HomeActivity::class.java)
            intent.putExtra("title",strTitle)
            intent.putExtra("rating",strrating)
            intent.putExtra("mrp",strmrp)
            intent.putExtra("color",strColor)
            intent.putExtra("img",img)
            context.startActivity(intent)
        }

        return binding.root
    }
}