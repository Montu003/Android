package com.app.share.adapter

import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.share.R
import com.app.share.databinding.ItemCategoryHomeBinding
import com.app.share.model.HomePage
import com.bumptech.glide.Glide
import com.example.vegiapp.api.Const

class CategoryHomeAdapter : RecyclerView.Adapter<CategoryHomeAdapter.HomeViewHolder>() {

    private var list : ArrayList<HomePage.Data.Category> = ArrayList()

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemCategoryHomeBinding

        init {
            binding = DataBindingUtil.bind(itemView)!!
        }

        fun setmodel(position: Int) {
            val category = list[position]
            binding.model = category
            binding.tvtitle.text = category.title

            // image load
            Glide.with(binding.root)
                .load(Const.ITEM_BASE_URL+category.image)
                .into(binding.ivIcon)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_category_home, parent, false)
        return HomeViewHolder(View)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int){
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun updatedata(category: ArrayList<HomePage.Data.Category>){
        this.list = category
        notifyDataSetChanged()
    }
}