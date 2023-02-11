package com.example.vegi.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.vegi.fragment.CartFragment
import com.example.vegi.fragment.CategoryFragment
import com.example.vegi.fragment.HomeFragment
import com.example.vegi.fragment.ProfileFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0-> HomeFragment();
            1-> CategoryFragment()
            2-> CartFragment()
            3-> ProfileFragment()
            else -> HomeFragment()
        }
    }
}