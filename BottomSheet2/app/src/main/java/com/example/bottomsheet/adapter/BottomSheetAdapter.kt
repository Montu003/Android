package com.example.bottomsheet.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.bottomsheet.R
import com.example.bottomsheet.databinding.ItemCouponBinding
import com.example.bottomsheet.model.Coupon

class BottomSheetAdapter():
    RecyclerView.Adapter<BottomSheetAdapter.BottomSheetBindingViewHolder>(){

    var list:ArrayList<Coupon> = ArrayList()

    inner class BottomSheetBindingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ItemCouponBinding? = null

        init {
            binding = DataBindingUtil.bind(itemView)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BottomSheetBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_coupon, parent, false)
        return BottomSheetBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: BottomSheetBindingViewHolder, position: Int){
        var data = list[position]
        holder.binding?.let{
            it.model = data
        }
    }

    override fun getItemCount() = list.size

    fun updateData(list: java.util.ArrayList<Coupon>) {
        this.list = list
        notifyItemRangeChanged(0, this.list.size)
    }
}