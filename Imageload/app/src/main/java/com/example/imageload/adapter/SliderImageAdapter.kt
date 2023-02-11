package com.example.imageload.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.imageload.R
import com.example.imageload.api.Const
import com.example.imageload.databinding.ImageSildeBinding
import com.example.imageload.model.homepage.HomePage

class SliderImageAdapter : RecyclerView.Adapter<SliderImageAdapter.SliderBindingViewHolder>() {

    private var list1: ArrayList<HomePage.Data.Banner> = ArrayList()

    inner class SliderBindingViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {

        var binding:ImageSildeBinding

        init {
            binding = DataBindingUtil.bind(itemview)!!
        }

        fun setModel(position: Int){
            val listmodel = list1[position]
            binding.model = listmodel

            // image load
            Glide.with(binding.root)
                .load(Const.ITEM_BASE_URL+listmodel.image)
                .placeholder(R.drawable.ic_baseline_person_24)
                .into(binding.ivAvater)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SliderBindingViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.image_silde, parent, false)
        return SliderBindingViewHolder(View)
    }

    override fun onBindViewHolder(holder: SliderBindingViewHolder, position: Int) {
        holder.setModel(position)
    }

    override fun getItemCount() = list1.size

    fun updateData1(categoryList1:ArrayList<HomePage.Data.Banner>){
        this.list1 = categoryList1
        notifyDataSetChanged()
    }

}