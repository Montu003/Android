package com.example.vegiapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.vegiapp.R
import com.example.vegiapp.api.Const
import com.example.vegiapp.databinding.ItemProductDetailBinding
import com.example.vegiapp.model.GetProduct

class ProductDetailAdapter : RecyclerView.Adapter<ProductDetailAdapter.ProductDetailViewHolder>(){

    private var list: ArrayList<GetProduct.Data.Image> = ArrayList()

    inner class ProductDetailViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemProductDetailBinding

        init {
            binding = DataBindingUtil.bind(itemView)!!
        }

        fun setmodel(position: Int) {
            val category = list[position]
            binding.model = category

            Log.i("TAG", "setmodel:"+category.image)
            Glide.with(itemView)
                .load(Const.ITEM_BASE_URL + category.image) //.get(0).image
                .placeholder(R.drawable.bell)
                .into(binding.ivIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductDetailViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_product_detail, parent, false)
        return ProductDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductDetailViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun updatedata(category: ArrayList<GetProduct.Data.Image>) {
        this.list = category
        notifyDataSetChanged()
    }
}