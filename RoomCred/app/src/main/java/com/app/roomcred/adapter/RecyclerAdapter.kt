package com.app.roomcred.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.app.roomcred.database.entity.User
import com.app.roomcred.databinding.CustomUserLayoutBinding
import com.app.roomcred.listner.OnItemClickListner

class RecyclerAdapter(var activity: Activity,var userList: MutableList<User>): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

   lateinit var binding: CustomUserLayoutBinding

   private lateinit var OnClickListner :OnItemClickListner

    fun setOnClickListner(OnClickListner: OnItemClickListner)
    {
        this.OnClickListner = OnClickListner
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        binding = CustomUserLayoutBinding.inflate(LayoutInflater.from(activity),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = userList[position]

        holder.bind.userId.text = "${user.id}"
        holder.bind.uvName.text = "${user.name}"
        holder.bind.uvEmail.text = "${user.email}"


        holder.bind.uvDelete.setOnClickListener {

            OnClickListner.OnDeleteReocrd(user)
        }

        holder.bind.uvUpdate.setOnClickListener {

            OnClickListner.OnUpdateRecord(user)
        }
    }

    override fun getItemCount() = userList.size

    class MyViewHolder(itemView: CustomUserLayoutBinding) : ViewHolder(itemView.root)
    {
        var bind = itemView
    }

    fun setItems(userList: MutableList<User>)
    {
        this.userList = userList
        notifyDataSetChanged()
    }
}