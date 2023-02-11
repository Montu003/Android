package com.example.app.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.database.entity.FirebaseTestUser
import com.example.app.listner.ChatOnClickListener
import com.example.weddingapp.R
import com.example.weddingapp.databinding.SearchLayoutBinding

class ChatAdapter(var context: Context) :
    RecyclerView.Adapter<ChatAdapter.MyViewHolder>() {

    lateinit var binding: SearchLayoutBinding


    var userChatList = arrayListOf<FirebaseTestUser>()

    private lateinit var listener: ChatOnClickListener

    fun setOnlistItemClickListener(listener: ChatOnClickListener){
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            SearchLayoutBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val chatUser = userChatList[position]

        holder.binding.ivProfileImage.setImageResource(R.drawable.ktv_image)
        holder.binding.tvName.text = chatUser.name
        //holder.binding.tvMessage.text = chat.text
//        holder.binding.tvDot.setImageResource(chat.dot)
//        holder.binding.tvMinit.text = chat.minte


        holder.binding.searchCard.setOnClickListener {
            listener.OnChatCardClicked(position, chatUser)
        }

    }

    override fun getItemCount(): Int {
        return userChatList.size
    }

    class MyViewHolder(val binding: SearchLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun userList(newlist: ArrayList<FirebaseTestUser>) {
        this.userChatList = newlist
        notifyDataSetChanged()
    }

    fun filterList(filterlist: ArrayList<FirebaseTestUser>) {
        this.userChatList = filterlist
        notifyDataSetChanged()
    }
}