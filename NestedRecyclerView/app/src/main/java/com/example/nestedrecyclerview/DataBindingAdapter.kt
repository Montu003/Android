package com.example.nestedrecyclerview

import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nestedrecyclerview.databinding.ItemDataBindingBinding
import com.example.nestedrecyclerview.model.Category

class DataBindingAdapter : RecyclerView.Adapter<DataBindingAdapter.DataBindingviewHolder>() {

    private var list:ArrayList<Category> = ArrayList()

    inner class DataBindingviewHolder(itemView : View):RecyclerView.ViewHolder(itemView) {

        fun setModel(position: Int) {
            val category =list[position]
            binding?.model =category
        }
        var binding:ItemDataBindingBinding? = null
        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBindingviewHolder {
       val view =LayoutInflater.from(parent.context).inflate(R.layout.item_data_binding,parent,false)
        return DataBindingviewHolder(view)
    }
    override fun onBindViewHolder(holder: DataBindingviewHolder, position: Int) {
        holder.setModel(position)
    }
    override fun getItemCount() = list.size

    fun updateData(categoryList: ArrayList<Category>){
        this.list = categoryList
        notifyDataSetChanged()
    }
}