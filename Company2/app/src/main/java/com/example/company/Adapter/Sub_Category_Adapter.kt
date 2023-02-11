package com.example.nestedrecycleview.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.company.Model.Sub_Category
import com.example.company.databinding.ItemChildLayoutBinding


class Sub_Category_Adapter(var context: Context, var subCategory:MutableList<Sub_Category>) : RecyclerView.Adapter<Sub_Category_Adapter.MyViewHolder>() {

    lateinit var binding: ItemChildLayoutBinding

    class MyViewHolder(var  binding: ItemChildLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemChildLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return  MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var category = subCategory[position]
        holder.binding.tvTitle.text = category.name
        holder.binding.btnRating.text = category.rating.toString()
        holder.binding.ivThumbnail.setImageResource(category.image)
        holder.binding.btnYear.text = category.year.toString()
    }

    override fun getItemCount(): Int {
        return  subCategory.size
    }
}
