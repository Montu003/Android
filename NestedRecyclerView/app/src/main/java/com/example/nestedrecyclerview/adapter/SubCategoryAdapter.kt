package com.example.nestedrecyclerview.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.R
import com.example.nestedrecyclerview.databinding.ItemChildLayoutBinding
import com.example.nestedrecyclerview.databinding.ItemParentLayoutBinding
import com.example.nestedrecyclerview.model.Category
import com.example.nestedrecyclerview.model.SubCategory

class SubCategoryAdapter:RecyclerView.Adapter<SubCategoryAdapter.SubCategoryBindingviewHolder>() {

    private var list1:ArrayList<SubCategory> = ArrayList()

   inner class SubCategoryBindingviewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {

       var binding:ItemChildLayoutBinding? = null
       init {
           binding = DataBindingUtil.bind(itemview)
       }
       fun setModel(position: Int) {

           val subCategory = list1[position]
           binding?.model = subCategory
            binding?.ivThumbnail?.setImageResource(subCategory.image)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): SubCategoryBindingviewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_child_layout,parent,false)
        return SubCategoryBindingviewHolder(view)
    }

    override fun onBindViewHolder(holder: SubCategoryBindingviewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list1.size

    fun     updateDate1(categoryList1:ArrayList<SubCategory>){
        this.list1 = categoryList1
        notifyDataSetChanged()
    }
}