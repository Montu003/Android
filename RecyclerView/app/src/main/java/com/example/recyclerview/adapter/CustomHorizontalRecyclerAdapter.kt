package com.example.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.ListHorizontalItemLayoutBinding
import com.example.recyclerview.model.movie

class CustomHorizontalRecyclerAdapter(var context: Context, var movieList: MutableList<movie>) :
    RecyclerView.Adapter<CustomHorizontalRecyclerAdapter.MyViewHolder>() {

    lateinit var binding: ListHorizontalItemLayoutBinding

    class MyViewHolder(val binding: ListHorizontalItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding =
            ListHorizontalItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie = movieList[position]

        holder.binding.tvTitle.text = movie.title
        holder.binding.rating.rating = movie.rating
        holder.binding.tvType.text = movie.type
        holder.binding.ivThumbnail.setImageResource(movie.image)

    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}