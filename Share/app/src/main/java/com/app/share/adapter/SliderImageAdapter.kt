package com.app.share.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.app.share.R
import com.app.share.databinding.ImageSildeBinding
import com.app.share.model.HomePage
import com.bumptech.glide.Glide
import com.example.vegiapp.api.Const

class SliderImageAdapter : RecyclerView.Adapter<SliderImageAdapter.SliderBindingViewHolder>() {

    private var list1: ArrayList<HomePage.Data.Banner> = ArrayList()

    inner class SliderBindingViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview) {

        var binding: ImageSildeBinding

        init {
            binding = DataBindingUtil.bind(itemview)!!
        }

        fun setModel(position: Int){
            val listmodel = list1[position]
            binding.model = listmodel

            // image load
            Glide.with(itemView)
                .load(Const.ITEM_BASE_URL+listmodel.image)
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