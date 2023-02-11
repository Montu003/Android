package com.example.vegiapp.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.vegiapp.R
import com.example.vegiapp.api.Const
import com.example.vegiapp.databinding.ItemSearchBinding
import com.example.vegiapp.model.SearchPage

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var list :ArrayList<SearchPage.Data> = ArrayList()

    inner class SearchViewHolder(itemView: View) : ViewHolder(itemView) {

          var binding:ItemSearchBinding
        var count = 0

         init {
             binding = DataBindingUtil.bind(itemView)!!
         }

        fun setmodel(position: Int){
            val category = list[position]
            binding.model = category

            Glide.with(itemView)
                .load(Const.ITEM_BASE_URL+category.images.get(0).image)
                .placeholder(R.drawable.ic_baseline_home_24)
                .into(binding.ivImages)

            // items increment and decrement
            binding.btnAdd.setOnClickListener {

                count++
                if (binding.btnAdd.visibility == View.VISIBLE) {
                    binding.btnAdd.visibility = View.GONE
                    binding.ivButton.visibility = View.VISIBLE
                }
            }

            binding.ivMinus.setOnClickListener {
                if (1 < count) {
                    count--
                    binding.tvQty.text = count.toString()
                    Log.d("TAG", "setModel: " + count)
                } else {
                    if (binding.ivButton.visibility == View.VISIBLE) {
                        binding.ivButton.visibility = View.GONE
                        binding.btnAdd.visibility = View.VISIBLE
                    }
                }
            }
            binding.btAddition.setOnClickListener {

                if (count < 7) {
                    Log.d("TAG", "setModel: " + count)
                    count++
                    binding.tvQty.text = count.toString()
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val View = LayoutInflater.from(parent.context).inflate(R.layout.item_search,parent,false)
        return SearchViewHolder(View)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.setmodel(position)
    }

    override fun getItemCount() = list.size

    fun updatedata(category : ArrayList<SearchPage.Data>){
        this.list = category
        notifyDataSetChanged()
    }
}