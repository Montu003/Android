package com.example.nestedrecycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.company.Model.All
import com.example.company.Model.Alll
import com.example.company.Model.Category
import com.example.company.Model.Sub_Category
import com.example.company.R
import com.example.company.databinding.ActivityMainBinding
import com.example.nestedrecycleview.Adapters.Category_Adapter

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var categoryList: MutableList<Category>
    lateinit var Lists:MutableList<All>
    lateinit var parentAdapter: Category_Adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prepareData()
        parentAdapter = Category_Adapter(this, categoryList)
        binding.parentView.layoutManager = LinearLayoutManager(this)
        binding.parentView.adapter = parentAdapter
    }

    private fun prepareData() {
        var movieList = mutableListOf<Sub_Category>()

        movieList.add(Sub_Category(1, "Pagal Panti",5.0f, R.drawable.image_11,2020))
        movieList.add(Sub_Category(2, "Dear Father",4.0f, R.drawable.image_12,2021))
        movieList.add(Sub_Category(3, "Chhichhore",5.0f, R.drawable.image_13,2022))
        movieList.add(Sub_Category(4, "Jeevi Laiye",3.0f, R.drawable.image_14,2022))
        movieList.add(Sub_Category(5, "Shiddat",5.0f, R.drawable.image_15,2015))


       /* movieList.add(Sub_Category(1,R.drawable.image_11))
        movieList.add(Sub_Category(1,R.drawable.image_12))
        movieList.add(Sub_Category(1,R.drawable.image_13))
        movieList.add(Sub_Category(1,R.drawable.image_14))
        movieList.add(Sub_Category(1,R.drawable.image_15))
*/
        var List = mutableListOf<Alll>()
        List.add(Alll(1,R.drawable.image_11))
        List.add(Alll(1,R.drawable.image_12))
        List.add(Alll(1,R.drawable.image_13))
        List.add(Alll(1,R.drawable.image_14))
        List.add(Alll(1,R.drawable.image_15))

        Lists = mutableListOf()
        Lists.add(All(R.drawable.image_11,List))
        Lists.add(All(R.drawable.image_12,List))
        Lists.add(All(R.drawable.image_13,List))
        Lists.add(All(R.drawable.image_14,List))
        Lists.add(All(R.drawable.image_15,List))

        categoryList = mutableListOf()
        categoryList.add(Category(1, "Top 10 Movies",movieList))
        categoryList.add(Category(2, "Recently Added", movieList))
        categoryList.add(Category(3, "ActionMovies", movieList))
        categoryList.add(Category(4, "Horroe Movies", movieList))

    }
}