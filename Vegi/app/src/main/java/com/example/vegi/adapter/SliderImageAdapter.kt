package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.RowItemBinding
import com.example.vegi.model.Listmodel

class SliderImageAdapter : RecyclerView.Adapter<SliderImageAdapter.SliderBindingViewHolder>() {

    private var list1: ArrayList<Listmodel> = ArrayList()

    inner class SliderBindingViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {
        var binding:RowItemBinding? = null

        init {
            binding = DataBindingUtil.bind(itemview)
        }

        fun setModel(position: Int){
            val listmodel = list1[position]
            binding?.model = listmodel
            binding?.ivAvater?.setImageResource(listmodel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.row_item, parent, false)
        return SliderBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: SliderBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list1.size

    fun updateData1(categoryList1:ArrayList<Listmodel>){
        this.list1 = categoryList1
        notifyDataSetChanged()
    }

}