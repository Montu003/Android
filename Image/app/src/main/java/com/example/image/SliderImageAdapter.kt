package com.example.image

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.squareup.picasso.Picasso

class SliderImageAdapter(var context:Context,var imageList:List<Int>):PagerAdapter() {

    private var inflater:LayoutInflater= LayoutInflater.from(context)

    override fun getCount(): Int {
        return imageList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
       return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        var imaLayout = inflater.inflate(R.layout.row_item,container,false)

        var imageView = imaLayout.findViewById(R.id.ivAvater) as ImageView
        imageView.setImageResource(0)

        Picasso.get()
            .load(imageList.get(position))
            .into(imageView)

        container.addView(imaLayout,0)
        return imaLayout
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}