package com.example.appvegi.adapterr

import android.icu.util.ULocale
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.appvegi.modele.Categori
import com.example.appvegi.R
import com.example.appvegi.databinding.CategoryBinding
import kotlin.collections.ArrayList

class CategorieAdapter : RecyclerView.Adapter<CategorieAdapter.CategoryBindingViewHolder>() {

    private var list: ArrayList<Categori> = ArrayList()

    inner class CategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        val SubCategoriesAdapter: SubCategoriesAdapter = SubCategoriesAdapter()
        var binding: CategoryBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int) {
            val category = list[position]
            binding?.model = category
            binding?.tvTitle?.text =category.title
            binding?.adapter  =SubCategoriesAdapter
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.category, parent, false)
        return CategoryBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: CategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list.size

    fun update(categotyList: ArrayList<Categori>) {
        this.list = categotyList
        notifyDataSetChanged()
    }
}