package com.example.list.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.list.R
import com.example.list.databinding.ItemCategoryBinding
import com.example.list.model.CategoryResponse
import com.example.list.model.Subcategory

class CategoryAdapter(var list:ArrayList<CategoryResponse.Data?> ) : RecyclerView.Adapter<CategoryAdapter.CategoryBindingViewHolder>() {



    inner class CategoryBindingViewHolder(val  binding: ItemCategoryBinding) : RecyclerView.ViewHolder(binding.root) {
//        var binding: ItemCategoryBinding? = null
//
//        init {
//            binding = DataBindingUtil.bind(itemview)
//        }
//
//        fun setModel(position: Int) {
//            val category = list[position]
//
//
//
//        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBindingViewHolder {
        return CategoryBindingViewHolder(ItemCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    }

    override fun onBindViewHolder(holder: CategoryBindingViewHolder, position: Int){

        val data = list[position]

        data?.let {

           holder.binding.ivIcon .load(it.profileCategoryImage) {
                crossfade(true)
              ///  placeholder(R.drawable.placeholder_image)
                transformations(CircleCropTransformation())
            }

            holder.binding.tvtitle.text = it.profileCategoryName

        }
    }

    override fun getItemCount() = list.size

    fun updateList(categoryList: ArrayList<CategoryResponse.Data?>?) {
        list = categoryList ?: ArrayList()
        notifyDataSetChanged()
    }
}