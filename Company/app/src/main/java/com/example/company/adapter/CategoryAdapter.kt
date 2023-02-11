package com.example.company.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.OnReceiveContentListener
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.company.Model.Category
import com.example.company.Model.SubCategory
import com.example.company.databinding.ItemParentLayoutBinding

class CategoryAdapter(var context: Context,var categoryList:MutableList<Category>):RecyclerView.Adapter<CategoryAdapter.MyViewHolder>() {

   lateinit var binding:ItemParentLayoutBinding
   lateinit var listener:ItemCilckListener

   interface ItemCilckListener{
       fun viewAllCilcked(id:Int,position: Int,title:Int)
        fun onChildItemClicked(view: View,subCategory: SubCategory)
   }

    fun setOnItemCilckListenet(listener: ItemCilckListener){
        this.listener =listener
    }

    class MyViewHolder(var binding: ItemParentLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int):MyViewHolder{
        binding = ItemParentLayoutBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }
    override fun onBindViewHolder(holder:MyViewHolder, position: Int) {
        var category = categoryList[position]
        holder.binding.tvTitle.text = category.title

        var adapter = SubCategotyAdapter(context,category.movieList,listener)
        binding.childView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL,false)
        binding.childView.adapter = adapter
    }
    override fun getItemCount(): Int {
       return categoryList.size
    }
}