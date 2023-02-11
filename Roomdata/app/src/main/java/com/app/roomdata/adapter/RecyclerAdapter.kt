package com.app.roomdata.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.roomdata.database.entity.User
import com.app.roomdata.databinding.ItemUserBinding

class RecyclerAdapter(var activity: Activity,var userList: MutableList<User>) : RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    lateinit var binding:ItemUserBinding

    class RecyclerViewHolder(itemView: ItemUserBinding) : ViewHolder(itemView.root) {

        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        binding = ItemUserBinding.inflate(LayoutInflater.from(activity),parent,false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var user = userList[position]

        holder.bind.tvId.text = "${user.id}"
        holder.bind.tvName.text = "${user.name}"
        holder.bind.tvEmail.text = "${user.email}"
    }

    override fun getItemCount() = userList.size

    fun setData(userList: MutableList<User>)
    {
        this.userList = userList
        notifyDataSetChanged()
    }
}