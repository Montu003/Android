package com.example.nestedrecycleview.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.company.Model.Category
import com.example.company.Model.Sub_Category
import com.example.company.databinding.ItemParentLayoutBinding

class Category_Adapter(var context: Context, var categoryList:MutableList<Category>) : RecyclerView.Adapter<Category_Adapter.MyViewHolder>() {

    lateinit var binding: ItemParentLayoutBinding
    lateinit var subCategoryAdapter: Sub_Category_Adapter

    class MyViewHolder(var  binding: ItemParentLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ItemParentLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return  MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var category = categoryList[position]
        holder.binding.tvTitle.text = category.title

        subCategoryAdapter = Sub_Category_Adapter(context, category.movieList)
        binding.childView.layoutManager =
            LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false);
        binding.childView.adapter = subCategoryAdapter

    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }
}