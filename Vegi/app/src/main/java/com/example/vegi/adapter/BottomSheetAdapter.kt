package com.example.vegi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.R
import com.example.vegi.databinding.ItemCouponBinding
import com.example.vegi.model.Coupon

class BottomSheetAdapter() :
    RecyclerView.Adapter<BottomSheetAdapter.ButtomSheetBindingViewHolder>() {

    var list: ArrayList<Coupon> = ArrayList()

    inner class ButtomSheetBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ItemCouponBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ButtomSheetBindingViewHolder {
        val View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_coupon, parent, false)
        return ButtomSheetBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: ButtomSheetBindingViewHolder, position: Int) {
        var data = list[position]
        holder.binding?.let {
            it.model = data
        }
    }

    override fun getItemCount() = list.size

    fun updateData(list:ArrayList<Coupon>) {
        this.list = list
        notifyItemRangeChanged(0, this.list.size)
    }
}