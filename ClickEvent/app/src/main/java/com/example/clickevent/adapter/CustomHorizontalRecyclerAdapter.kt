package com.example.recyclerview.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.clickevent.HomeActivity
import com.example.clickevent.databinding.ListHorizontalBinding
import com.example.clickevent.listener.OnListItemClickListener
import com.example.clickevent.model.movie
import com.example.clickevent.model.phone


class CustomHorizontalRecyclerAdapter(var context: Context, var movieList:MutableList<movie>):RecyclerView.Adapter<CustomHorizontalRecyclerAdapter.MyViewHolder>() {

    private lateinit var listener: OnListItemClickListener
    lateinit var binding:ListHorizontalBinding

    fun setOnListItemClickListener(listener: OnListItemClickListener){
        this.listener = listener
    }

    class MyViewHolder(val binding: ListHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = ListHorizontalBinding.inflate(LayoutInflater.from(context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var movie  = movieList[position]

        holder.binding.tvTitle.text = movie.title
        holder.binding.rating.rating = movie.rating
        holder.binding.tvType.text = movie.type
        holder.binding.ivThumbnail.setImageResource(movie.image)


        holder.binding.ivThumbnail.setOnClickListener{
                listener.onImageClicked(it,position,movie)
        }

        holder.binding.llhorizontal.setOnClickListener {
             listener.onItemLayout(it,position)
        }


        holder.binding.parent.setOnClickListener{
            listener.onCardClicked(position,movie)
        }
    }
    override fun getItemCount(): Int {
        return movieList.size
    }
}