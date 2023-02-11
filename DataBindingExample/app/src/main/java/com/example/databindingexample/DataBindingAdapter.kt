package com.example.databindingexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.databindingexample.databinding.ItemDataBinidngBinding
import com.example.nestedrecyclerview.model.Category

class DataBindingAdapter : RecyclerView.Adapter<DataBindingAdapter.DataBindingViewHolder>() {

    private var list: ArrayList<Category> = ArrayList()

    inner class DataBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun setModel(position: Int) {
            val category = list[position]
            binding?.model = category
        }

        var binding: ItemDataBinidngBinding? = null
        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_data_binidng, parent, false)
        return DataBindingViewHolder(view)
    }
    override fun onBindViewHolder(holder: DataBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list.size

    fun updateData(categoryList: ArrayList<Category>) {
        this.list = categoryList
        notifyDataSetChanged()
    }

}