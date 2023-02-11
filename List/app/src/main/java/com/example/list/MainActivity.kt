package com.example.list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.list.adapter.CategoryAdapter
import com.example.list.databinding.ActivityMainBinding
import com.example.list.model.Subcategory
import com.example.list.utils.Resource
import com.example.list.viewmodel.CategoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
   lateinit var categoryAdapter: CategoryAdapter
    private val viewModel: CategoryViewModel by viewModels()
    ///private val categoryList: ArrayList<Category> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        categoryAdapter = CategoryAdapter(arrayListOf())
        binding.rvCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvCategory.adapter = categoryAdapter
       // binding.adapter = categoryAdapter

        viewModel.getCatData()
        viewModel.categoryResponseLive.observe(this, Observer {

            when(it){
                is Resource.Success -> {
                    val list = it.data?.data
                    list?.let {
                        Log.e("TAG", "onCreate:$it ", )
                        categoryAdapter.updateList(it)
                    }

                }
                is Resource.Error ->{

                }
                is Resource.Loading ->{

                }//progress bar

            }
        })
    }
}