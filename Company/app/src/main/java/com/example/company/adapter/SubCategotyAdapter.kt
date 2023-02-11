package com.example.company.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.company.Model.SubCategory
import com.example.company.databinding.ItemChildLayoutBinding

class SubCategotyAdapter(var context: Context,var SubcaregotyList:MutableList<SubCategory>,var listener: CategoryAdapter.ItemCilckListener):RecyclerView.Adapter<SubCategotyAdapter.MyViewHolder>() {

    lateinit var binding: ItemChildLayoutBinding

    class MyViewHolder(var binding: ItemChildLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):MyViewHolder {
        binding = ItemChildLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategotyAdapter.MyViewHolder, position: Int) {

        var SubCategory = SubcaregotyList[position]
        holder.binding.tvTitle.text = SubCategory.title
        holder.binding.tvType.text=SubCategory.type
        holder.binding.ivImage.setImageResource(SubCategory.image)
        holder.binding.tvRating.text= SubCategory.rating.toString()

        holder.binding.cardparnet.setOnClickListener {
            listener.onChildItemClicked(it,SubCategory)
        }
    }

    override fun getItemCount(): Int {
        return SubcaregotyList.size
    }
}
