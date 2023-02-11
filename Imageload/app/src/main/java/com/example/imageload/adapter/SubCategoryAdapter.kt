package com.example.imageload.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.imageload.R
import com.example.imageload.databinding.ItemSubcategoryListBinding
import com.example.imageload.model.homepage.HomePage

class SubCategoryAdapter : RecyclerView.Adapter<SubCategoryAdapter.SubCategoryViewHolder>() {

    private var list: ArrayList<HomePage.Data.CategoryWithProduct> = ArrayList()

   inner class SubCategoryViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemSubcategoryListBinding
        var productAdapter: ProductAdapter

       init{
           binding = DataBindingUtil.bind(itemView)!!
           productAdapter = ProductAdapter()
       }

       fun setmodel(position: Int){
           val category = list[position]
           binding.model = category

          // binding.rvProduct.layoutManager = LinearLayoutManager(itemView.context,LinearLayoutManager.HORIZONTAL,false)
           binding.rvProduct.adapter=productAdapter

           productAdapter.update(category.products as ArrayList<HomePage.Data.CategoryWithProduct.Product>)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory_list,parent,false)
        return SubCategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun update(category: ArrayList<HomePage.Data.CategoryWithProduct>) {
        this.list = category
        notifyDataSetChanged()
    }
}