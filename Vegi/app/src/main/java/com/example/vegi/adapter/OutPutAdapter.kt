package com.example.vegi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.databinding.ItemSubBinding
import com.example.vegi.databinding.OutputBinding
import com.example.vegi.model.ItemSubCategory

class OutPutAdapter(var context: Context, var list: ArrayList<ItemSubCategory>) :
    RecyclerView.Adapter<OutPutAdapter.MyViewHolder>() {

    class MyViewHolder(var binding: OutputBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            OutputBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var subcategory = list[position]
        holder.binding.model = subcategory
        holder.binding.ivImage.setImageResource(subcategory.image)
        holder.binding.tvtitle.text = subcategory.title
        holder.binding.tvPrice.setText(subcategory.price)
    }

    override fun getItemCount(): Int = list.size

}
