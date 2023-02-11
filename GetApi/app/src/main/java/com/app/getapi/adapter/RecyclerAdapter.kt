package com.app.getapi.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.getapi.databinding.ItemUserBinding
import com.app.getapi.model.User

class RecyclerAdapter(var activity: Activity, var userList: MutableList<User>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewAdapter>() {

    lateinit var binding: ItemUserBinding

    class RecyclerViewAdapter(itemView: ItemUserBinding) : ViewHolder(itemView.root) {

        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewAdapter {
        binding = ItemUserBinding.inflate(LayoutInflater.from(activity), parent, false)
        return RecyclerViewAdapter(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter, position: Int) {
        var user = userList[position]

        holder.bind.tvName.text = "${user.fName} ${user.lName}"
        holder.bind.tvEmail.text = "${user.email}"
    }

    override fun getItemCount() = userList.size
    fun setData(userList: MutableList<User>)
    {
        this.userList = userList
        notifyDataSetChanged()

    }
}