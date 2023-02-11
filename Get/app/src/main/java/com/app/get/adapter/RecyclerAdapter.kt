package com.app.get.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.get.databinding.ItemCustomeBinding
import com.app.get.model.User

class RecyclerAdapter(var activity: Activity, var userList: MutableList<User>) :
    RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder>() {

    lateinit var binding: ItemCustomeBinding

    class RecyclerViewHolder(itemView: ItemCustomeBinding) : ViewHolder(itemView.root) {

        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        binding = ItemCustomeBinding.inflate(LayoutInflater.from(activity), parent, false)
        return RecyclerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        var user = userList[position]

        holder.bind.tvName.text = "${user.fName} ${user.lName}"
        holder.bind.tvEmail.text = "${user.email}"
    }

    override fun getItemCount() = userList.size

    fun setData(userList: MutableList<User>) {
        this.userList = userList
        notifyDataSetChanged()
    }
}