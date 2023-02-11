package com.example.auto_image

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class SildeAdapter internal  constructor(
    sildeItem: MutableList<Sildeitem>,
    viewPager2:ViewPager2
):RecyclerView.Adapter<SildeAdapter.SildeviewHolder>(){

    private val silderItems:List<Sildeitem>
   // private val viewPager2:ViewPager2

    init {
        this.silderItems = sildeItem
//        this.viewPager2 = viewPager2
    }

    class SildeviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val imageView:RoundedImageView = itemView.findViewById(R.id.imageSlide)

        fun image(sildeItem: Sildeitem){
            imageView.setImageResource(sildeItem.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SildeviewHolder {
        return SildeviewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.silde_item,parent,false
            )
        )
    }
    override fun onBindViewHolder(holder: SildeviewHolder, position: Int) {
        holder.image(silderItems[position])
        if (position == silderItems.size - 2){
//            viewPager2.post(runnable)
        }
    }
    override fun getItemCount(): Int {
        return silderItems.size
    }
    private val runnable = Runnable {
        sildeItem.addAll(sildeItem)
        notifyDataSetChanged()
    }
}