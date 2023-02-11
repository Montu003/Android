package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.PhoneItemListBinding
import com.example.recyclerview.model.phone

class CustomRecyclerAdapter(var context: Context, var phoneList: MutableList<phone>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    lateinit var binding: PhoneItemListBinding

    class MyViewHolder(val binding: PhoneItemListBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = PhoneItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var phone = phoneList[position]

        holder.binding.tvTitle.text = phone.title
        holder.binding.tvRating.rating = phone.rating
        holder.binding.tvMrp.text = "${phone.mrp}"
        holder.binding.tvTitle.text = phone.title
        holder.binding.ivMontu.setImageResource(phone.image)

    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

}