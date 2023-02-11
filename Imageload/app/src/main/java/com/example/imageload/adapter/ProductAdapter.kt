package com.example.imageload.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.imageload.R
import com.example.imageload.api.Const
import com.example.imageload.databinding.ItemSubcategoryBinding
import com.example.imageload.model.homepage.HomePage

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.SubCategoryViewHolder>(){

    private var list: ArrayList<HomePage.Data.CategoryWithProduct.Product> = ArrayList()

   inner class SubCategoryViewHolder(itemView: View) : ViewHolder(itemView){

        var binding: ItemSubcategoryBinding

       init{
           binding = DataBindingUtil.bind(itemView)!!
       }

       fun setmodel(position: Int){
           val category = list[position]
           binding.model = category

          Glide.with(itemView)
              .load(Const.ITEM_BASE_URL+category.images.get(0).image)
              .placeholder(R.drawable.ic_launcher_background)
              .into(binding.ivImage)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory,parent,false)
        return SubCategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun update(category: ArrayList<HomePage.Data.CategoryWithProduct.Product>) {
        this.list = category
        notifyDataSetChanged()
    }
}