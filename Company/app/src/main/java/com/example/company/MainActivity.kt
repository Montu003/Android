package com.example.company

import android.icu.text.Transliterator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.company.Model.Category
import com.example.company.Model.SubCategory
import com.example.company.adapter.CategoryAdapter
import com.example.company.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var categoryList: MutableList<Category>
    lateinit var parentAdapter:CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()

        categoryList= ArrayList<Category>()

        parentAdapter = CategoryAdapter(this,categoryList)
        binding.parentView.layoutManager = LinearLayoutManager(this)
        binding.parentView.adapter = parentAdapter

        parentAdapter.setOnItemCilckListenet(object : CategoryAdapter.ItemCilckListener{
            override fun viewAllCilcked(id: Int, position: Int, title: Int) {
                Toast.makeText(applicationContext, "$title : $position", Toast.LENGTH_SHORT).show()
            }
            override fun onChildItemClicked(view: View, subCategory: SubCategory) {
                    Toast.makeText(applicationContext, "${subCategory.title} : ${subCategory.id}", Toast.LENGTH_SHORT).show()
            }
        })
        }
    private fun prepareData() {
        var movieList = mutableListOf<SubCategory>()

        movieList.add(SubCategory(1,"Kgf","Kgf",5.0f,R.drawable.image_12))
        movieList.add(SubCategory(1,"bahubali","bahubali",4.0f,R.drawable.image_13))
        movieList.add(SubCategory(1,"Nadi dosh","Nadi dosh",4.0f,R.drawable.image_4))
        movieList.add(SubCategory(1,"Radheshyam","Radheshyam",4.0f,R.drawable.image_6))
        movieList.add(SubCategory(1,"bahubali","bahubali",4.0f,R.drawable.image_13))
    }
}