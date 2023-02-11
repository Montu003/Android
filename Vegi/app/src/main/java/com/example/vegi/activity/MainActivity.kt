package com.example.vegi.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import com.example.vegi.R
import com.example.vegi.adapter.MainViewPagerAdapter
import com.example.vegi.databinding.ActivityMainBinding

//share pref,roomdatabase,auto slider with indicator,bottom sheet fragment or dialog,navigation drawer,navigation component,liveData,mvvm section
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        initListener()
    }

    private fun initView() {
        val mainViewPagerAdapter = MainViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPager.adapter = mainViewPagerAdapter
        binding.viewPager.isUserInputEnabled = false
    }

    private fun initListener() {
        binding.ivMenu.setOnClickListener {
            binding.drawer.openDrawer(GravityCompat.START)
        }
     //   binding.btnProgressBar.visibility = View.VISIBLE
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.action_Home -> {

                    binding.viewPager.setCurrentItem(0, false)
                    true
                }
                R.id.action_Category -> {

                    binding.viewPager.setCurrentItem(1, false)
                    true
                }
                R.id.action_Cart -> {

                    binding.viewPager.setCurrentItem(2, false)
                    true
                }
                R.id.action_Profile -> {

                    binding.viewPager.setCurrentItem(3, false)
                    true
                }
                else -> true
            }
        }
        binding.btnSearch.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            intent.putExtra("title",title)
            startActivity(intent)
        }
    }
    /*private fun addFragment(title: String, Fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, Fragment, title)
            addToBackStack(null)
            commit()
        }
    }*/
}