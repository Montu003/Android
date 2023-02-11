package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemSearchCategoryBinding
import com.example.vegi.model.Subcategory

class CategorySearchAdapter : RecyclerView.Adapter<CategorySearchAdapter.CategoryBindingViewHolder>() {

    private var list : List<Subcategory> = ArrayList()

    inner class CategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var binding: ItemSearchCategoryBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int) {
            val subcategory = list[position]
            binding?.model = subcategory
            binding?.ivIcon?.setImageResource(subcategory.image)
            binding?.tvtitle?.text = subcategory.title
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_search_category, parent, false)
        return CategoryBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: CategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list.size

    fun setdata(categoryList1: ArrayList<Subcategory>) {
        this.list = categoryList1
        notifyDataSetChanged()
    }
}