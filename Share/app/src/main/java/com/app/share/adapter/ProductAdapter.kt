package com.app.share.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.share.R
import com.app.share.databinding.ItemSubcategoryBinding
import com.app.share.model.HomePage
import com.bumptech.glide.Glide
import com.example.vegiapp.api.Const

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.SubCategoryViewHolder>(){

    private var list: ArrayList<HomePage.Data.CategoryWithProduct.Product> = ArrayList()

   inner class SubCategoryViewHolder(itemView: View) : ViewHolder(itemView){

        var binding: ItemSubcategoryBinding
       var count = 0

       init{
           binding = DataBindingUtil.bind(itemView)!!
       }

       fun setmodel(position: Int){
           val category = list[position]

          Glide.with(itemView)
              .load(Const.ITEM_BASE_URL+category.images.get(0).image)
              .placeholder(R.drawable.ic_launcher_background)
              .into(binding.ivImage)

           binding.model = category

           // items increment and decrement
           binding.btnAdd.setOnClickListener {

               count++
               if (binding.btnAdd.visibility == View.VISIBLE) {
                   binding.btnAdd.visibility = View.GONE
                   binding.btnAdddata.visibility = View.VISIBLE
               }
           }

           binding.ivMinus.setOnClickListener {
               if (1 < count) {
                   count--
                   binding.tvQty.text = count.toString()
                   Log.d("TAG", "setModel: " + count)
               } else {
                   if (binding.btnAdddata.visibility == View.VISIBLE) {
                       binding.btnAdddata.visibility = View.GONE
                       binding.btnAdd.visibility = View.VISIBLE
                   }
               }
           }
           binding.btAddition.setOnClickListener {

               if (count < 7) {
                   Log.d("TAG", "setModel: " + count)
                   count++
                   binding.tvQty.text = count.toString()
               }
           }
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubCategoryViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory,parent,false)
        return SubCategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: SubCategoryViewHolder, position: Int){
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun update(category: ArrayList<HomePage.Data.CategoryWithProduct.Product>) {
        this.list = category
        notifyDataSetChanged()
    }
}