package com.gautam.validatonformgrewon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gautam.validatonformgrewon.databinding.IteamlistCircalBinding
import com.gautam.validatonformgrewon.modal.IteamList

class ItemAdapter(var context: Context, var itemlist: MutableList<IteamList>) :
    RecyclerView.Adapter<ItemAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: IteamlistCircalBinding) : RecyclerView.ViewHolder(itemView.root) {
        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = IteamlistCircalBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var iteam = itemlist[position]
        holder.bind.tvItemlist.text = iteam.text

        Glide.with(context)
            .load(iteam.image)
            .centerCrop()
            .into(holder.bind.iteamCircleimage)
    }

    override fun getItemCount(): Int {
        return itemlist.size
    }
}
