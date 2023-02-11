package com.example.nestedrecyclerview

import android.database.DatabaseUtils
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.nestedrecyclerview.adapter.Category_Adapter
import com.example.nestedrecyclerview.adapter.SubCategoryAdapter
import com.example.nestedrecyclerview.databinding.ActivityMainBinding
import com.example.nestedrecyclerview.model.Category
import com.example.nestedrecyclerview.model.SubCategory

class MainActivity : AppCompatActivity() {

    private val categoryList:ArrayList<Category> = ArrayList()
    private val categoryList1:ArrayList<SubCategory> = ArrayList()
    private val dataBindingAdapter:DataBindingAdapter = DataBindingAdapter()
    private val Category_Adapter:Category_Adapter = Category_Adapter()
    private val subCategoryAdapter:SubCategoryAdapter = SubCategoryAdapter()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        prepareData()
        binding.adapter = Category_Adapter
        Category_Adapter.updateData(categoryList)
    }

    private fun prepareData() {
        var movieList = ArrayList<SubCategory>()
        movieList.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList1 = ArrayList<SubCategory>()

        movieList1.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList1.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList1.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList1.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList1.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList2 = ArrayList<SubCategory>()
        movieList2.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList2.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList2.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList2.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList2.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList3 = ArrayList<SubCategory>()

        movieList3.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList3.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList3.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList3.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList3.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        val movieList4 = ArrayList<SubCategory>()

        movieList4.add(SubCategory(1, "Kgf", "Kgf", 5.0f, R.drawable.image_12))
        movieList4.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))
        movieList4.add(SubCategory(1, "Nadi dosh", "Nadi dosh", 4.0f, R.drawable.image_4))
        movieList4.add(SubCategory(1, "Radheshyam", "Radheshyam", 4.0f, R.drawable.image_6))
        movieList4.add(SubCategory(1, "bahubali", "bahubali", 4.0f, R.drawable.image_13))

        categoryList.add(Category(1, "Watchlist", movieList))
        categoryList.add(Category(2, "Adventure", movieList1))
        categoryList.add(Category(3, "Popular movie", movieList2))
        categoryList.add(Category(4, "Trending shows", movieList3))
        categoryList.add(Category(5, "original web show", movieList4))

    }
}