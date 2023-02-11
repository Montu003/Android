package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemOrderDetailsBinding
import com.example.vegi.model.OrderListModel

class OrderAdapter(var list: ArrayList<OrderListModel>) :
    RecyclerView.Adapter<OrderAdapter.OrderBindingViewHolder>() {

    var onClick: ((OrderListModel, Int) -> Unit)? = null

    inner class OrderBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ItemOrderDetailsBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderBindingViewHolder {
        val View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_order_details, parent, false)
        return OrderBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: OrderBindingViewHolder, position: Int) {
        var data = list[position]
        holder.binding?.let {
            it.model = data
            it.btnCard.setOnClickListener {
                onClick?.invoke(data, position)
            }
        }
    }

    override fun getItemCount(): Int = list.size

    fun filterList(newList: ArrayList<OrderListModel>) {
        this.list = newList
        notifyDataSetChanged()
    }
}