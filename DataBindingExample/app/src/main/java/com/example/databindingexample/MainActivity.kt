package com.example.databindingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.DataBindingUtil
import com.example.databindingexample.databinding.ActivityMainBinding
import com.example.nestedrecyclerview.model.Category
import com.example.nestedrecyclerview.model.SubCategory

class MainActivity : AppCompatActivity() {

    private var categoryList: ArrayList<Category> = ArrayList()
    private val dataBindingAdapter: DataBindingAdapter = DataBindingAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        prepareData()
        binding.adapter = dataBindingAdapter
        dataBindingAdapter.updateData(categoryList)
    }
    private fun prepareData() {
        var movieList = mutableListOf<SubCategory>()
        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList1 = mutableListOf<SubCategory>()

        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList2 = mutableListOf<SubCategory>()
        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList3 = mutableListOf<SubCategory>()

        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        var movieList4 = mutableListOf<SubCategory>()

        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        categoryList.add(Category(1, "Watchlist", movieList))
        categoryList.add(Category(2, "Adventure", movieList1))
        categoryList.add(Category(3, "Popular movie", movieList2))
        categoryList.add(Category(4, "Trending shows", movieList3))
        categoryList.add(Category(5, "original web show", movieList4))

    }
}