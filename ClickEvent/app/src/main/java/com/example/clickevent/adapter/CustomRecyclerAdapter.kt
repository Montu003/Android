package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.clickevent.databinding.ListVerticalBinding
import com.example.clickevent.listener.OnListItemClickListener
import com.example.clickevent.model.phone

class CustomRecyclerAdapter(var context: Context, var phoneList:MutableList<phone>):RecyclerView.Adapter<CustomRecyclerAdapter.MyViewHolder>() {

    lateinit var binding:ListVerticalBinding
    private lateinit var listener: OnListItemClickListener



    fun setOnListItemVarClickListener(listener: OnListItemClickListener){
        this.listener = listener
    }


    class MyViewHolder(val binding: ListVerticalBinding) :
        RecyclerView.ViewHolder(binding.root){
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ListVerticalBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var phone  = phoneList[position]

        holder.binding.tvTitle.text = phone.title
        holder.binding.tvRating.rating = phone.rating
        holder.binding.tvMrp.text = "${phone.mrp}"
        holder.binding.tvTitle.text = phone.title
        holder.binding.ivMontu.setImageResource(phone.image)

        holder.binding.ivMontu.setOnClickListener{
            //  Toast.makeText(context, "Image : $position", Toast.LENGTH_SHORT).show()
            listener.onImagephoneClicked(it,position,phone)
        }

        holder.binding.llVartical.setOnClickListener {
            Toast.makeText(context, "Image : $position", Toast.LENGTH_SHORT).show()
            listener.onItemLayout(it,position);
        }

        holder.binding.parent.setOnClickListener{
            listener.onCardPhoneClicked(position,phone)
        }

    }

    override fun getItemCount(): Int {
        return phoneList.size
    }

}