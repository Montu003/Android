package com.example.appvegi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appvegi.databinding.CetegoriesBinding
import com.example.appvegi.model.cetgoriesModel

class CategoriesAdapter(var context: Context, var cetlist: MutableList<cetgoriesModel>) :
    RecyclerView.Adapter<CategoriesAdapter.ViewData>() {

    lateinit var binding: CetegoriesBinding
    lateinit var subCetAdapter: subCetegoriesAdapter

    class ViewData(itemView: CetegoriesBinding) : RecyclerView.ViewHolder(itemView.root) {
        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewData {
        binding = CetegoriesBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewData(binding)
    }

    override fun onBindViewHolder(holder: ViewData, position: Int) {
        var listData = cetlist[position]
        binding.tvTitle.text = listData.name

        subCetAdapter = subCetegoriesAdapter(context, listData.listSubcat)
        binding.rvCatList.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCatList.adapter = subCetAdapter
    }

    override fun getItemCount(): Int {
        return cetlist.size
    }
}