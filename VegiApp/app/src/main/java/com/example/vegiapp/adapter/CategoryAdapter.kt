package com.example.vegiapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.vegiapp.R
import com.example.vegiapp.api.Const
import com.example.vegiapp.databinding.ItemCategoryBinding
import com.example.vegiapp.model.CategoryPage

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var list : ArrayList<CategoryPage.Data> = ArrayList()

   inner class CategoryViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemCategoryBinding

       init {
           binding = DataBindingUtil.bind(itemView)!!
       }

       fun setmodel(position: Int){
           var category = list[position]
           binding.model = category

           Glide.with(itemView)
               .load(Const.ITEM_BASE_URL+category.image)
               .placeholder(R.drawable.bell)
               .into(binding.ivimage)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun update(category : ArrayList<CategoryPage.Data>){
        this.list = category
        notifyDataSetChanged()
    }
}