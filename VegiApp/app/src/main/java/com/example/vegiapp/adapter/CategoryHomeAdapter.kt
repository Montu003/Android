package com.example.vegiapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.vegiapp.R
import com.example.vegiapp.activity.SearchActivity
import com.example.vegiapp.api.Const
import com.example.vegiapp.databinding.ItemCategoryHomeBinding
import com.example.vegiapp.model.HomePage

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
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(binding.ivIcon)

            binding.ivIcon.setOnClickListener {
                var intent = Intent(Intent(binding.ivIcon.context,SearchActivity::class.java)) // homecategory pass searchactivity
                binding.ivIcon.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_category_home, parent, false)
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