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
import com.example.imageload.databinding.ItemHomeBinding
import com.example.imageload.model.homepage.HomePage

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private var list : ArrayList<HomePage.Data.Category> = ArrayList()

    inner class HomeViewHolder(itemView: View) : ViewHolder(itemView) {

        var binding: ItemHomeBinding

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
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(binding.ivIcon)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(View)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun updatedata(category: ArrayList<HomePage.Data.Category>){
        this.list = category
        notifyDataSetChanged()
    }
}