package com.gautam.validatonformgrewon.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gautam.validatonformgrewon.dao.ClickEventCard
import com.gautam.validatonformgrewon.databinding.FragmentListrecyclerBinding
import com.gautam.validatonformgrewon.modal.Listview

class ListViewAdepter(var context: Context, var listview: MutableList<Listview>) :
    RecyclerView.Adapter<ListViewAdepter.MyViewHolder>() {

    var listner: ClickEventCard? = null
    fun setOnlistItemClickListener(listener: ClickEventCard) {
        this.listner = listener
    }

    class MyViewHolder(itemView: FragmentListrecyclerBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var bind = itemView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding =
            FragmentListrecyclerBinding.inflate(LayoutInflater.from(context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var list = listview[position]
        holder.bind.tvTitel.text = list.title
        holder.bind.rattingPoint.text = list.ratting.toString()
        holder.bind.tvDescription.text = list.description

        Glide.with(context)
            .load(list.image)
            .centerCrop()
            .into(holder.bind.ivTmage)

        holder.itemView.setOnClickListener {
            listner?.onCardClicked(pos = position, food = list)
        }
    }

    override fun getItemCount(): Int {
        return listview.size
    }
}
