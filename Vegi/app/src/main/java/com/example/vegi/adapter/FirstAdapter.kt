package com.example.vegi.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vegi.databinding.FirstBinding
import com.example.vegi.model.First

class FirstAdapter(var context: Context) : RecyclerView.Adapter<FirstAdapter.MyViewHolder>() {

    var list1 = ArrayList<First>()

    class MyViewHolder(var binding: FirstBinding) : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            FirstBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var subcategory = list1[position]
        holder.binding.model = subcategory
        holder.binding.tvImage.setImageResource(subcategory.image)
        holder.binding.tvTitle.text = subcategory.title
        holder.binding.tvPric.setText(subcategory.price)
        holder.binding.tvPri.setText(subcategory.pric)

        holder.binding.btnAdd.setOnClickListener {
            if (holder.binding.btnAdd.visibility == View.VISIBLE) {
                holder.binding.btnAdd.visibility = View.GONE
                holder.binding.btnAdddata.visibility = View.VISIBLE
            }
        }

        holder.binding.btnAdd.setOnClickListener {

            if (holder.binding.btnAdd.visibility == View.VISIBLE) {
                holder.binding.btnAdd.visibility = View.GONE
                holder.binding.btnAdddata.visibility = View.VISIBLE
            }
        }

        var count = 1
        holder.binding.ivMinus.setOnClickListener {

            if (1 < count) {
                count--
                holder.binding.tvQty.text = count.toString()
                Log.d("TAG", "onCreateView: " + count)
            } else {
                if (holder.binding.btnAdddata.visibility == View.VISIBLE) {
                    holder.binding.btnAdddata.visibility = View.GONE
                    holder.binding.btnAdd.visibility = View.VISIBLE
                }
            }
        }

        holder.binding.btAddition.setOnClickListener {

            if (count < 7) {
                Log.d("TAG", "onCreateView: " + count)
                count++
                holder.binding.tvQty.text = count.toString()
            }
        }
    }

    override fun getItemCount() = list1.size

    fun seData(category:ArrayList<First>){
        this.list1 = category
        notifyDataSetChanged()
    }
}