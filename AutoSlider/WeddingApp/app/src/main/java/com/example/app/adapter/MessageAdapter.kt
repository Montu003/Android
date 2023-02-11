package com.example.app.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.database.entity.Message
import com.example.weddingapp.databinding.ReceiverRcvLayoutBinding
import com.example.weddingapp.databinding.SenderRcvLayoutBinding
import com.google.firebase.auth.FirebaseAuth
import java.sql.Timestamp
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class MessageAdapter(
    var context: Context,
    var senderid: String?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val SENDER = 1
    private val RECEIVER = 2
    private var messageList: ArrayList<Message>  = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == SENDER) {
            SenderViewHolder(
                SenderRcvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            ReceiverViewHolder(
                ReceiverRcvLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        val cuurentMessage = messageList[position]

        if (holder is SenderViewHolder) {
            holder.binding.senderMessage.text = cuurentMessage.message
            holder.binding.senderMessageTime.text = Timestamp(cuurentMessage.time ?: 0).toString()

        } else {
            val viewHolder = holder as ReceiverViewHolder
            holder.binding.receiveMessageTime.text = Timestamp(cuurentMessage.time ?: 0).toString()
            holder.binding.receiveMessage.text = cuurentMessage.message

        }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {


        val cuurentMessage = messageList[position]

        if (FirebaseAuth.getInstance().currentUser?.uid?.equals(cuurentMessage.senderId) == true) {
            Log.e("TAG", "currentUser: if"+FirebaseAuth.getInstance().currentUser?.uid )
            return SENDER;
        } else {
            Log.e("TAG", "getItemViewType: else" )
            return RECEIVER;
        }

}

    class SenderViewHolder(val binding: SenderRcvLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    class ReceiverViewHolder(val binding: ReceiverRcvLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)


    fun setMessageList(newMessageList: ArrayList<Message>) {
        this.messageList = newMessageList
        notifyItemChanged(messageList.size)
    }

//    fun formatDurationTime(durationSeconds: Long) =
//        durationSeconds.seconds.toComponents { hours, minutes, seconds, _ ->
//            String.format(
//                Locale.getDefault(),
//                "%02d:%02d:%02d",
//                hours,
//                minutes,
//                seconds,
//            )
//        }




}