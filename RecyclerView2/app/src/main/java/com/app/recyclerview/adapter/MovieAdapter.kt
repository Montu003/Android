package com.app.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.recyclerview.databinding.ItemMovieBinding
import com.app.recyclerview.model.movie

class MovieAdapter(var context: Context, var movieList: MutableList<movie>) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    lateinit var binding: ItemMovieBinding

    class MovieViewHolder(itemView: ItemMovieBinding) : RecyclerView.ViewHolder(itemView.root) {

        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding = ItemMovieBinding.inflate(LayoutInflater.from(context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        var movie = movieList[position]

        holder.bind.tvTitle.text = movie.title
        holder.bind.tvType.text = movie.type
        holder.bind.rating.rating = movie.rating
        holder.bind.tvYear.text = "${movie.year}"
        holder.bind.ivImage.setImageResource(movie.image)
    }

    override fun getItemCount() = movieList.size

}