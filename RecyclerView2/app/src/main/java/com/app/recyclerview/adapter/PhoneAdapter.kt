package com.app.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.PhoneItemListBinding
import com.app.recyclerview.model.phone

class PhoneAdapter(var context: Context, var phoneList: MutableList<phone>) :
    RecyclerView.Adapter<PhoneAdapter.PhoneViewHolder>() {

    lateinit var binding: PhoneItemListBinding

    class PhoneViewHolder(itemView: PhoneItemListBinding) : RecyclerView.ViewHolder(itemView.root) {

        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        binding = PhoneItemListBinding.inflate(LayoutInflater.from(context), parent, false)
        return PhoneViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val phone = phoneList[position]

        holder.bind.tvTitle.text = phone.title
        holder.bind.tvRating.rating = phone.rating
        holder.bind.tvMrp.text = "$phone.mrp"
        holder.bind.tvColor.text = phone.color
        holder.bind.ivMontu.setImageResource(phone.image)
    }

    override fun getItemCount() = phoneList.size
}