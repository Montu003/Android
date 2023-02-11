package com.example.appvegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.appvegi.Fragment.CartFragment
import com.example.appvegi.Fragment.CategoriesFragment
import com.example.appvegi.Fragment.HomeFragment
import com.example.appvegi.Fragment.ProfileFragment
import com.example.appvegi.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_home)

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                    R.id.action_Home ->{
                        Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                        addFragment("Home",HomeFragment())
                        true
                    }
                R.id.action_Category ->{
                    Toast.makeText(this, "Category", Toast.LENGTH_SHORT).show()
                    addFragment("Categories",CategoriesFragment())
                    true
                }
                R.id.action_Cart ->{
                    Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show()
                    addFragment("Cart",CartFragment())
                    true
                }
                R.id.action_Profile ->{
                    Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show()
                    addFragment("Profile",ProfileFragment())
                    true
                }
                else -> true
            }
        }
    }
    private fun addFragment(title: String, Fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,Fragment,title)
            addToBackStack(null)
            commit()
        }
    }
}