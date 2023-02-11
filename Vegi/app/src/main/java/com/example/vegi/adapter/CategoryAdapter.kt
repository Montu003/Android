package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemCategoryBinding
import com.example.vegi.model.First
import com.example.vegi.model.Subcategory

class CategoryAdapter : RecyclerView.Adapter<CategoryAdapter.CategoryBindingViewHolder>() {

    private var list: ArrayList<Subcategory> = ArrayList()
    lateinit var listener:catItemClicked
    var list1:ArrayList<First> = ArrayList()

    interface catItemClicked{
        fun itemClicked(position: Int,title:String)
        fun ChlidData(position: Int, Img: Int, list1: ArrayList<First>)
    }

    fun OnClicked(listener:catItemClicked){
        this.listener = listener
    }
    inner class CategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var binding: ItemCategoryBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int){
            val subcategory = list[position]
            binding?.model = subcategory
            binding?.ivIcon?.setImageResource(subcategory.image)
            binding?.tvtitle?.text = subcategory.title
            binding?.card?.setOnClickListener {
                listener.itemClicked(position,subcategory.title)
            }

            binding?.ivIcon?.setOnClickListener {
                listener.ChlidData(position,subcategory.image,list1)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return CategoryBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: CategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list.size

    fun update(categoryList: ArrayList<Subcategory>) {
        this.list = categoryList
        notifyDataSetChanged()
    }
}