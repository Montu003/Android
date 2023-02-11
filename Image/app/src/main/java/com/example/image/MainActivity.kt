package com.example.image

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Adapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TimePicker
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.image.databinding.ActivityMainBinding
import com.example.image.model.listModel
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var itemeList = mutableListOf<listModel>()
    lateinit var adapterslider:SliderImageAdapter

    companion object{
        private var currentPage=0
        private var Num_pages=0
    }

    var imageList = listOf(R.drawable.image_2,R.drawable.image_3,R.drawable.image_4,R.drawable.image_5,R.drawable.image_12)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AutoSlider()
        //updateIndicator()

    }
   /* private fun updateIndicator() {

            binding.indicatorDots.removeAllViews()

            var indicators = arrayOfNulls<ImageView>(3)

            for( i in indicators.indices){
                indicators[i] = ImageView(applicationContext)

                if(i==index){
                    indicators[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.indicator_activity))
                }else{
                    indicators[i]?.setImageDrawable(ContextCompat.getDrawable(applicationContext, R.drawable.in_indicator_activity))
                }

                var param = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                param.setMargins(20, 0,0,0)

                binding.indicatorDots.addView(indicators[i], param)
            }*/
      //  }

    private fun AutoSlider(){
        adapterslider = SliderImageAdapter(this,imageList)
        binding.ViewautoScroll.adapter = adapterslider

        var density=resources.displayMetrics.density

        Num_pages=imageList.size

        var handles=Handler()
        var updater= Runnable {
            if (currentPage == Num_pages){
                currentPage=0
            }
            binding.ViewautoScroll.setCurrentItem(currentPage++,true)
        }

        var SwimTimer= Timer()
        SwimTimer.schedule(object : TimerTask(){
            override fun run() {
                handles.post (updater)
            }
        },1000,2000)
    }
}