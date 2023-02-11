package com.example.vegi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemSubBinding
import com.example.vegi.model.ItemSubCategory
import com.example.vegi.model.Sub

class SubCategoryAdapter(var context: Context) :
    RecyclerView.Adapter<SubCategoryAdapter.SubcategoryBindingViewHolder>() {

    private var list1: ArrayList<Sub> = ArrayList()
    lateinit var listener: itemClicked

    interface itemClicked {
        fun seeAllClicked(position: Int, title: String, list: ArrayList<ItemSubCategory>)
        fun ChildItemAddBtnClicked(position: Int, title: String)
        fun ChlidDataPasss(position: Int, Img: Int,i_add:Int, list: ArrayList<ItemSubCategory>)
    }

    fun OnClicked(listener: itemClicked) {
        this.listener = listener
    }

    inner class SubcategoryBindingViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview) {

        //var binding: ItemSubcategoryBinding? = null
        var binding: ItemSubBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int) {
            val subcategory = list1[position]
            binding?.model = subcategory
            /* binding?.tvTitle?.text = subcategory.title
             binding?.adapter = Subcategoryadp(subcategory.list1,listener)
             binding?.rvSubLi?.layoutManager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
             binding?.rvSubLi?.adapter = binding?.adapter*/
            binding?.let {
                it.tvTitle.text = subcategory.title

                it.adapter = Subcategoryadp(subcategory.list1, listener)
                it.rvSubLi.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                it.rvSubLi.adapter = binding?.adapter

                it.btnSeeAll.setOnClickListener {
                    listener.seeAllClicked(position, subcategory.title, subcategory.list1)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubcategoryBindingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sub, parent, false)
        //  val view = LayoutInflater.from(parent.context).inflate(R.layout.item_subcategory,parent,false)
        return SubcategoryBindingViewHolder(view)
    }

    override fun onBindViewHolder(holder: SubcategoryBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list1.size

    fun subupdate(categoryList: ArrayList<Sub>) {
        this.list1 = categoryList
        notifyDataSetChanged()
    }
}