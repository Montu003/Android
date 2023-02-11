package com.example.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bottomnavigation.databinding.ActivityMainBinding
import com.example.bottomnavigation.fragment.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolBar.title = "Home"
        setSupportActionBar(binding.toolBar)

        addFragment("Home",HomeFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.action_home ->{
                    Toast.makeText(this, "Home", Toast.LENGTH_SHORT).show()
                    addFragment("Home",HomeFragment())
                    true
                }
                R.id.action_search ->{
                    Toast.makeText(this, "search", Toast.LENGTH_SHORT).show()
                    addFragment("search",SearchFragment())
                    true
                }
                R.id.action_cart ->{
                    Toast.makeText(this, "cart", Toast.LENGTH_SHORT).show()
                    addFragment("cart",CartFragment())
                    true
                }
                R.id.action_favorite ->{
                    Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show()
                    addFragment("favorite",FavoriteFragment())
                    true
                }
                R.id.action_person ->{
                    Toast.makeText(this, "person", Toast.LENGTH_SHORT).show()
                    addFragment("person",PersonFragment())
                    true
                }
                else  -> true
            }
        }
    }
    private fun addFragment(title: String, Fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container,Fragment,title)
            addToBackStack(null)
            commit()
        }
        binding.toolBar.title = title
    }
}