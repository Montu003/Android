package com.example.appvegi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appvegi.R
import com.example.appvegi.databinding.SubcategoriesBinding

import com.example.appvegi.model.subCatModel

class subCetegoriesAdapter(var context: Context,var subCatList:MutableList<subCatModel>):RecyclerView.Adapter<subCetegoriesAdapter.ViewData>(){

    lateinit var binding: SubcategoriesBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding= SubcategoriesBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
         var subCatListdata=subCatList[position]
         binding.tvtitle.text=subCatListdata.name
         binding.ivIcon.setImageResource(subCatListdata.img)
    }

    override fun getItemCount(): Int {
       return subCatList.size
    }

    class ViewData(itemView:SubcategoriesBinding) : RecyclerView.ViewHolder(itemView.root){

    }
}