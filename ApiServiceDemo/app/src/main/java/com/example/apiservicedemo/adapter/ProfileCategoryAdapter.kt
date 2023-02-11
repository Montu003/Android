package com.example.apiservicedemo.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.apiservicedemo.R
import com.example.apiservicedemo.api.Const
import com.example.apiservicedemo.databinding.ItemProfilecategoryBinding
import com.example.apiservicedemo.model.profilecategory.ProfileCategory

class ProfileCategoryAdapter : RecyclerView.Adapter<ProfileCategoryAdapter.ProfileCategoryViewHolder>() {

    private var list: ArrayList<ProfileCategory.Data> = ArrayList()

    inner class ProfileCategoryViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemProfilecategoryBinding

        init{
            binding = DataBindingUtil.bind(itemView)!!
        }

        fun setModel(position: Int) {
            val subcategory = list[position]
            binding.model = subcategory

            // image load
            Glide.with(binding.root)
                .load(Const.ITEM_BASE_URL+subcategory.profileCategoryImage)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileCategoryViewHolder {
        val View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_profilecategory, parent, false)
        return ProfileCategoryViewHolder(View)
    }

    override fun onBindViewHolder(holder: ProfileCategoryViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list.size

    fun update(category: ArrayList<ProfileCategory.Data>){
        this.list = category
        notifyDataSetChanged()
    }
}