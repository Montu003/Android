package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemDeliverydetailsBinding
import com.example.vegi.model.Delivery
import java.lang.reflect.Array.get

class DeliverydetailsAdapter(var list1: ArrayList<Delivery>) :
    RecyclerView.Adapter<DeliverydetailsAdapter.DeliverydetailsBindingViewHolder>() {

    private var index = 0

    inner class DeliverydetailsBindingViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        var binding: ItemDeliverydetailsBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeliverydetailsBindingViewHolder {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_deliverydetails, parent, false)
        return DeliverydetailsBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: DeliverydetailsBindingViewHolder,position:Int) {

        var data1 = list1[position]
        holder.binding?.radioButton?.isChecked = position== index
        holder.binding?.let {
            it.model = data1
            it.root.setOnClickListener {
                index = position
                notifyDataSetChanged()
            }
        }
    }
    override fun getItemCount() = list1.size

    fun filter(newList: ArrayList<Delivery>) {
        this.list1 = newList
        notifyDataSetChanged()
    }
}