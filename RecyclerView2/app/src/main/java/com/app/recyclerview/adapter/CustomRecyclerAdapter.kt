package com.app.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.PhoneItemBinding
import com.app.recyclerview.model.phonedata

class CustomRecyclerAdapter(var context: Context, var phoneList: MutableList<phonedata>) :
    RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    lateinit var binding: PhoneItemBinding

    class MyViewHolder(val binding: PhoneItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = PhoneItemBinding.inflate(LayoutInflater.from(context), parent, false)
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