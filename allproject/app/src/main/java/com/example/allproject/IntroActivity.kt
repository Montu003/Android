package com.example.onboardingscreen.activity

import android.content.ClipData
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager.widget.ViewPager
import com.example.allproject.R
import com.example.allproject.databinding.ActivityIntroBinding
import com.example.allproject.model.Item
import com.example.allproject.sharePref.PrefManager
import com.example.onboardingscreen.adapter.CustomPagerAdapter
import com.example.uidesign21_6.LoginActivity

class IntroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntroBinding
    private var itemList = mutableListOf<Item>()
    private lateinit var adapter: CustomPagerAdapter
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        //pass data to adapter using adapterview
        adapter = CustomPagerAdapter(this,itemList)
        binding.viewPager.adapter = adapter
        binding.viewPager.currentItem = index

        binding.viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }
            override fun onPageSelected(position: Int) {
                index = position
                if (index==adapter.count-1)
                {
                    binding.btnNext.text = "Finish"
                    binding.btnSkip.visibility = View.GONE
                    startActivity(Intent(applicationContext,LoginActivity::class.java))
                }
                else{
                    binding.btnNext.text = "Next "
                    binding.btnSkip.visibility = View.VISIBLE
                }
                updateIndicator(index)
            }
            private fun updateIndicator(index: Int) {
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
                }
            }
            override fun onPageScrollStateChanged(state: Int) {
            }
        })
        binding.btnNext.setOnClickListener {
            if (index<=adapter.count-1)
            {
                index++
                binding.viewPager.currentItem = index
            }
            else{
                updatePref()
                var intent=Intent(this,LoginActivity::class.java)
                startActivity(intent)
            }
        }
        binding.btnSkip.setOnClickListener {
            supportFragmentManager.beginTransaction()
            //.add()
            updatePref()
            //startActivity(Intent(this,LoginActivity::class.java))
        }
    }

    fun updatePref(){
       var prefManager=PrefManager(this)
       prefManager.setIntroStatus(true)
       startActivity(Intent(this,LoginActivity::class.java))
    }

    private fun prepareData() {
        itemList.add(Item(1,"fresh Food","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu auctor mauris. Vestibulum vestibulum, purus nec imperdiet accumsan,", R.drawable.onboarding1))
        itemList.add(Item(2,"Fast Delivery","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu auctor mauris. Vestibulum vestibulum, purus nec imperdiet accumsan,",R.drawable.onboarding2))
        itemList.add(Item(3,"Easy payment","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu auctor mauris. Vestibulum vestibulum, purus nec imperdiet accumsan,",R.drawable.onboarding3))
    }
}