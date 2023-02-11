package com.example.appvegi.adapterr

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appvegi.modele.SubCategori
import com.example.appvegi.R
import com.example.appvegi.databinding.CetegoriesBinding

class SubCategoriesAdapter : RecyclerView.Adapter<SubCategoriesAdapter.SubCategoriesBindingViewHolder>() {

    private var list1:ArrayList<SubCategori> = ArrayList()

    inner class SubCategoriesBindingViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {

        var binding: CetegoriesBinding? = null
        init {
            binding =  DataBindingUtil.bind(itemView)
        }
        fun setModel(position: Int) {
            val subCategory = list1[position]
           // binding?.model = subCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): SubCategoriesBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.cetegories,parent,false)
        return SubCategoriesBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: SubCategoriesBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list1.size
}