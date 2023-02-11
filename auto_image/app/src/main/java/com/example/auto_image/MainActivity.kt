package com.example.auto_image

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private val sliderHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPager2 = findViewById(R.id.viewPager)

        val sildeitem:MutableList<Sildeitem> = ArrayList()
        sildeitem.add(Sildeitem(R.drawable.image_3))
        sildeitem.add(Sildeitem(R.drawable.image_1))
        sildeitem.add(Sildeitem(R.drawable.image_13))
        sildeitem.add(Sildeitem(R.drawable.image_51))
        sildeitem.add(Sildeitem(R.drawable.image_2))
        sildeitem.add(Sildeitem(R.drawable.image_4))
        sildeitem.add(Sildeitem(R.drawable.image_5))
        sildeitem.add(Sildeitem(R.drawable.image_6))


        viewPager2.adapter = SildeAdapter(sildeitem,viewPager2)

        viewPager2.clipToPadding = false
        viewPager2.clipChildren = false
        viewPager2.offscreenPageLimit = 3
        viewPager2.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_ALWAYS

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(30))
        compositePageTransformer.addTransformer{page,position ->
            val r = 1 - abs(position)
            page.scaleX = 0.85f + r * 0.25f
        }
        viewPager2.setPageTransformer(compositePageTransformer)

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                sliderHandler.removeCallbacks(silderRunnable)
                sliderHandler.postDelayed(silderRunnable,1000)
            }
        })
    }
    private val silderRunnable = Runnable {
        viewPager2.currentItem = viewPager2.currentItem + 1
    }
}